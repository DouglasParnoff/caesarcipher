package com.caesarcipher.service;

public interface CaesarCipher extends CipherService {
	public char getSubstituteChar(char source, int numberAhead);
}