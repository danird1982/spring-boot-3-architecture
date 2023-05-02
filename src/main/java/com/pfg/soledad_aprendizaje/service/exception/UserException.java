package com.pfg.soledad_aprendizaje.service.exception;

public class UserException extends Exception {

	private static final long serialVersionUID = 4577113928327813610L;

	public UserException() {
	}

	public UserException(String message) {
		super(message);
	}

	public UserException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserException(Throwable cause) {
		super(cause);
	}

}
