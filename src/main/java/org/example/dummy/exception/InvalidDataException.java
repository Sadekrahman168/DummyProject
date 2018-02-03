package org.example.dummy.exception;
/**
 * Custom Exception class to Handle Invalid Data.
 * @author sadekrahman
 *
 */
public class InvalidDataException extends RuntimeException {
   	private static final long serialVersionUID = 1L;

	public InvalidDataException(String description) {
        super(description);
    }
	public InvalidDataException(String description, Throwable causeOfException) {
        super(description,causeOfException);
    }
}
