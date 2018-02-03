package org.example.dummy.exception;

/**
 * Custom Exception class to Handle non-existing Entity.
 * @author sadekrahman
 *
 */
public class NotFoundException extends RuntimeException {
   	private static final long serialVersionUID = 1L;

	public NotFoundException(String description) {
        super(description);
    }
}