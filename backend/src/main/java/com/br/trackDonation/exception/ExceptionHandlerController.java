package com.br.trackDonation.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ResponseErrorMessage> badRequestException(BadRequestException badRequestException, HttpServletRequest request){
		ResponseErrorMessage erro = new ResponseErrorMessage();
		erro.setMessage(badRequestException.getMessage());
		erro.setPath(request.getRequestURI());
		erro.setStatus(HttpStatus.BAD_REQUEST);
		erro.setStatusCode(HttpStatus.BAD_REQUEST.value());
		erro.setTimestamp(Instant.now());
		return ResponseEntity.status(erro.getStatusCode()).body(erro);
	}
}
