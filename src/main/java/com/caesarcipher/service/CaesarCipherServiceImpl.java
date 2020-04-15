package com.caesarcipher.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

import com.caesarcipher.alphabetcharfinder.CharFinderFactory;
import com.caesarcipher.alphabetcharfinder.CharFinderService;
import com.caesarcipher.dto.RequestMessageDTO;
import com.caesarcipher.external.ExternalService;
import com.caesarcipher.internal.InternalService;
import com.caesarcipher.model.RequestMessage;

@Service
public class CaesarCipherServiceImpl implements CaesarCipher {

	@Override
	public RequestMessageDTO decodeChallenge(RequestMessageDTO message) {
		message = ExternalService.getExternalMessage(message);
		InternalService.saveMessageToJsonFile(message);
		RequestMessage model = RequestMessage.getModelFromDTO(message);
		model = decrypt(model);
		InternalService.saveMessageToJsonFile(RequestMessageDTO.getDTOFromModel(model));
		model = summary(model);
		InternalService.saveMessageToJsonFile(RequestMessageDTO.getDTOFromModel(model));
		message = RequestMessageDTO.getDTOFromModel(model);
		
		return message;
	}

	@Override
	public RequestMessage decrypt(RequestMessage message) {
		StringBuilder word = new StringBuilder();

		for (char a : message.getEncoded().toCharArray()) {
			word.append(getSubstituteChar(a, -1 * message.getPositionsNumber()));
		}
		message.setDecoded(word.toString());
		return summary(message);
	}
	
	@Override
	public char getSubstituteChar(char source, int positionsToChange) {
		char substituteChar = source;

		if (positionsToChange == 0)
			return substituteChar;

		CharFinderService charFinder = CharFinderFactory.getServiceInstance(positionsToChange);
		// if not found, then it is source char
		if (charFinder.getCharPosition(source) < 0)
			return substituteChar;

		int targetPosition = charFinder.getTargetPosition(source, positionsToChange);

		substituteChar = charFinder.getCharAtPosition(targetPosition);

		return substituteChar;
	}	

	@Override
	public RequestMessage summary(RequestMessage message) {
		try {

			MessageDigest cryptSummary = MessageDigest.getInstance("SHA-1");
			byte messageDigest[] = cryptSummary.digest(message.getDecoded().getBytes("UTF-8"));

			StringBuilder hexaStringBuilder = new StringBuilder();
			
			for (byte b : messageDigest) {
				hexaStringBuilder.append(String.format("%02X", 0xFF & b));
			}
			message.setSummary(hexaStringBuilder.toString());

			cryptSummary.reset();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public RequestMessage encrypt(RequestMessage message) {
		String encodedWord = null;
		for (char a : message.getDecoded().toCharArray()) {

		}
		return message;
	}	
	
}
