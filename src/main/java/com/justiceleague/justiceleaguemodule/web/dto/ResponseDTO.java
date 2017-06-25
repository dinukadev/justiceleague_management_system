package com.justiceleague.justiceleaguemodule.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class ResponseDTO {

	private Status status;

	private String message;

	
	public ResponseDTO(Status status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public enum Status{
		SUCCESS,
		FAIL
	}
}
