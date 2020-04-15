package com.caesarcipher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caesarcipher.dto.RequestMessageDTO;
import com.caesarcipher.external.ExternalService;
import com.caesarcipher.internal.InternalService;
import com.caesarcipher.model.RequestMessage;
import com.caesarcipher.service.CaesarCipher;

@RestController
@RequestMapping("/caesar")
public class CaesarCipherController {
	
	@Autowired
	private CaesarCipher caesarService;
	
	@GetMapping
	public ResponseEntity<String> works(){
		return ResponseEntity.status(HttpStatus.OK).body("works");
	}
	
	@GetMapping(path = "/decode/{token}", produces = "application/json")
	public ResponseEntity<RequestMessageDTO> decodeTest(
			@PathVariable String token) {
		RequestMessageDTO message = new RequestMessageDTO();
		message.setToken(token);
		message = caesarService.decodeChallenge(message);			
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}
	
	@GetMapping(path = "/v1/decode/{token}", produces = "application/json")
	public ResponseEntity<String> decodeChallenge(
			@PathVariable String token) {
		RequestMessageDTO message = new RequestMessageDTO();
		message.setToken(token);
		message = caesarService.decodeChallenge(message);
		String response = ExternalService.sendFile(message);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}	
}
