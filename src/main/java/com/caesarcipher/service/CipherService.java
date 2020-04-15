package com.caesarcipher.service;

import com.caesarcipher.dto.RequestMessageDTO;
import com.caesarcipher.model.RequestMessage;

public interface CipherService {
	public RequestMessageDTO decodeChallenge(RequestMessageDTO message);

	public RequestMessage decrypt(RequestMessage message);

	public RequestMessage summary(RequestMessage message);

	public RequestMessage encrypt(RequestMessage message);

}
