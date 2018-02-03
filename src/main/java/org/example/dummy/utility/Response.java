package org.example.dummy.utility;

/**
 * A custom Response object to Represents REST response to end user.
 * 
 * @author sadekrahman
 *
 */
public class Response {

	/**
	 * Status of a Response.
	 * 
	 * @author sadekrahman
	 *
	 */
	public static enum Status {
		OK, ERROR
	}

	public static final class CustomError {
		private final int errorCode;
		private final String description;

		public CustomError(int errorCode, String description) {
			this.errorCode = errorCode;
			this.description = description;
		}

		public int getErrorCode() {
			return errorCode;
		}

		public String getDescription() {
			return description;
		}
	}

	private final Status status;
	private final Object data;
	private final CustomError error;

	public Response(Status status, Object data) {
		this(status, data, null);
	}

	public Response(Status status, Object data, CustomError error) {
		this.status = status;
		this.data = data;
		this.error = error;
	}

	public Status getStatus() {
		return status;
	}

	public Object getData() {
		return data;
	}

	public CustomError getError() {
		return error;
	}
}
