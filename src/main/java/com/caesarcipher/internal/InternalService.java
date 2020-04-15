package com.caesarcipher.internal;

import java.io.File;
import java.io.IOException;

import com.caesarcipher.dto.RequestMessageDTO;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class InternalService {

	public static final String FILE_NAME = "answer.json";

	public static RequestMessageDTO getMessageFromJsonFile() {
		RequestMessageDTO message = new RequestMessageDTO();
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			message = objectMapper.readValue(new File(FILE_NAME), RequestMessageDTO.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	public static void saveMessageToJsonFile(RequestMessageDTO message) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
			objectMapper.writeValue(new File(FILE_NAME), message);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static File getFile() {
		return new File(FILE_NAME);
	}
		
}
