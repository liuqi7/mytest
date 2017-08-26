package com.itheima.ssm.exception;

public class ItemException extends Exception {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ItemException(String message) {
		this.message = message;
	}

	public ItemException() {
	}
	
}
