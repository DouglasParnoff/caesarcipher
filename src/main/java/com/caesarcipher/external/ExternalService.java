package com.caesarcipher.external;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.caesarcipher.dto.RequestMessageDTO;
import com.caesarcipher.internal.InternalService;

public class ExternalService {
	private static final String EXTERNAL_BASE_URL = "https://api.codenation.dev/v1/challenge/dev-ps";
	private static final String SUFIX_OF_GET = "generate-data";
	private static final String SUFIX_OF_POST = "submit-solution";

	public static RequestMessageDTO getExternalMessage(RequestMessageDTO message) {
		RequestMessageDTO dtoResponse = new RequestMessageDTO();
		RestTemplate restTemplate = new RestTemplate();
		String entryPoint = String.format("%s/%s?token=%s", EXTERNAL_BASE_URL, SUFIX_OF_GET, message.getToken());
		ResponseEntity<RequestMessageDTO> response = restTemplate.getForEntity(entryPoint, RequestMessageDTO.class);

		dtoResponse = response.getBody();
		dtoResponse.setToken(message.getToken());

		return dtoResponse;
	}

	public static String sendFile(RequestMessageDTO message) {
		
		File answer = InternalService.getFile();
		FileSystemResource resource = new FileSystemResource(answer); 
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		
		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		body.add("answer", resource);

		HttpEntity<MultiValueMap<String, Object>> requestEntity
		 = new HttpEntity<>(body, headers);
		 
		String serverUrl =  String.format("%s/%s?token=%s", EXTERNAL_BASE_URL, SUFIX_OF_POST, message.getToken());
		 
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate
		  .postForEntity(serverUrl, requestEntity, String.class);

		return response.getBody();
	}

	public static String getPostEntryPoint(RequestMessageDTO message) {
		return String.format("%s/%s?token=%s", EXTERNAL_BASE_URL, SUFIX_OF_POST, message.getToken());
	}
}
