package com.br.trackDonation.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
	
	ResponseErrorMessage erro = new ResponseErrorMessage();
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ResponseErrorMessage> badRequestException(BadRequestException badRequestException, HttpServletRequest request){
		erro.setMessage(badRequestException.getMessage());
		erro.setPath(request.getRequestURI());
		erro.setStatus(HttpStatus.BAD_REQUEST);
		erro.setStatusCode(HttpStatus.BAD_REQUEST.value());
		erro.setTimestamp(Instant.now());
		
		return ResponseEntity.status(erro.getStatusCode()).body(erro);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ResponseErrorMessage> userNotFoundException(UserNotFoundException userNotFoundException, HttpServletRequest request){
		erro.setMessage(userNotFoundException.getMessage());
		erro.setPath(request.getRequestURI());
		erro.setStatus(HttpStatus.NOT_FOUND);
		erro.setStatusCode(HttpStatus.NOT_FOUND.value());
		erro.setTimestamp(Instant.now());
		
		return ResponseEntity.status(erro.getStatus()).body(erro);
	}
}
