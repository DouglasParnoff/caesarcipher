package com.caesarcipher.model;

import com.caesarcipher.dto.RequestMessageDTO;

public class RequestMessage {
	private int positionsNumber;
	private String token;
	private String encoded;
	private String decoded;
	private String summary;
	
	public int getPositionsNumber() {
		return positionsNumber;
	}
	public void setPositionsNumber(int positionsNumber) {
		this.positionsNumber = positionsNumber;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getEncoded() {
		return encoded;
	}
	public void setEncoded(String encoded) {
		this.encoded = encoded;
	}
	public String getDecoded() {
		return decoded;
	}
	public void setDecoded(String decoded) {
		this.decoded = decoded;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public static RequestMessage getModelFromDTO(RequestMessageDTO dto) {
		RequestMessage model = new RequestMessage();
		model.setToken(dto.getToken());
		model.setEncoded(dto.getCifrado());
		model.setDecoded(dto.getDecifrado());
		model.setPositionsNumber(dto.getNumero_casas());
		model.setSummary(dto.getResumo_criptografico());
		return model;
	}
	
}
