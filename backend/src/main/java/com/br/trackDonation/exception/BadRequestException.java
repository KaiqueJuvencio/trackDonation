package com.br.trackDonation.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private ResponseErrorMessage responseErrorMessage;
	
	public BadRequestException(String message) {
		super(message);
		this.responseErrorMessage = new ResponseErrorMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST, message);
	}

	public ResponseErrorMessage getErrorMessage() {
		return responseErrorMessage;
	}
}