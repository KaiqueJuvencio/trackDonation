package com.br.trackDonation.exception;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseErrorMessage {
	@JsonProperty(value = "errorType")
	private HttpStatus error;
	@JsonProperty(value = "errorCode")
	private int status;
	private String message;
	
	public ResponseErrorMessage(int status, HttpStatus error, String message) {
		super();
		this.status = status;
		this.error = error;
		this.message = message;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public HttpStatus getError() {
		return error;
	}
	public void setError(HttpStatus error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "ResponseErrorMessage [status=" + status + ", error=" + error + ", message=" + message + "]";
	}
}
