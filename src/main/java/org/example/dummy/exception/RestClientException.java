package org.example.dummy.exception;

import org.example.dummy.utility.Response.CustomError;

/**
 * Custom exception class to handle External-REST Exception.
 * 
 * @author sadekrahman
 *
 */
public class RestClientException extends RuntimeException {

	private static final long serialVersionUID = 2789017069143115323L;

	private final int errorCode;
	private final String errorDescription;

	public RestClientException(CustomError error) {
		super(error.getErrorCode() + ": " + error.getDescription());
		this.errorCode = error.getErrorCode();
		this.errorDescription = error.getDescription();
	}

	public int getErrorCode() {
		return errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}
}