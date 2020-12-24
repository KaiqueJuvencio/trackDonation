package com.br.trackDonation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandlerController {
	
	public ResponseEntity<ResponseErrorMessage> badRequestException(BadRequestException badRequestException){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(badRequestException.getErrorMessage());
	}
}
