package com.task.assignment.exception;

public class TradeDetailsNotFoundException extends RuntimeException{
	
	private String message;
	
	public TradeDetailsNotFoundException(String message) {
		this.message=message;
	}
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
