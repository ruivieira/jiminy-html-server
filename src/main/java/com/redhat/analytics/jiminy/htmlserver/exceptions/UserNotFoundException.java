package com.redhat.analytics.jiminy.htmlserver.exceptions;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private static final String USER_ERR_MSG = "Could Not find This Id: ";
	private String id;

	public UserNotFoundException(String id) {
		this.id = id;
	}

	@Override
	public String getMessage() {
		return USER_ERR_MSG + id;
	}
}
