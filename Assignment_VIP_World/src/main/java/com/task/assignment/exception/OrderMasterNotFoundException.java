package com.task.assignment.exception;

public class OrderMasterNotFoundException extends RuntimeException {
	private String message;

	public OrderMasterNotFoundException(String message) {
		this.message=message;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
