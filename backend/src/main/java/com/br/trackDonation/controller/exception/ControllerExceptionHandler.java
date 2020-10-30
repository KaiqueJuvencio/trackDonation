package com.br.trackDonation.controller.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<StandardError> userNotFound(UserNotFoundException e, HttpServletRequest request){
		StandardError erro = new StandardError();
		erro.setMessage("Usuário não encontrado");
		erro.setError(e.getMessage());
		erro.setStatus(HttpStatus.SC_NOT_FOUND);
		erro.setTimestamp(Instant.now());
		erro.setPath(request.getRequestURI());
		return ResponseEntity.status(erro.getStatus()).body(erro);
	}
}
