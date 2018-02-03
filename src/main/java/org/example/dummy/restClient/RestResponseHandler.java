package org.example.dummy.restClient;

import java.util.concurrent.Callable;
import org.example.dummy.exception.RestClientException;
import org.example.dummy.utility.Response.CustomError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

/**
 * 
 * Rest API response Handler.
 * 
 * @author sadekrahman
 *
 */
public class RestResponseHandler {

	/**
	 * Handles a Collable Interface to process REST response.
	 * 
	 * @param invocation
	 * @return
	 */
	public static Object handle(Callable<ResponseEntity<Object>> invocation) {
		if (invocation == null) {
			throw new IllegalArgumentException("Cannot be null");
		}
		try {
			ResponseEntity<Object> response = invocation.call();
			if (response.getStatusCode() != HttpStatus.OK) {
				throw new RestClientException(
						new CustomError(response.getStatusCode().value(), "Unable to process External Call."));
			}
			return response.getBody();
		} catch (HttpClientErrorException e) {
			throw new RestClientException(new CustomError(e.getStatusCode().value(), e.getMessage()));
		} catch (Exception e) {
			throw new RestClientException(new CustomError(0, e.toString()));
		}
	}

}
