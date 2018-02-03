package org.example.dummy.resources;

import org.example.dummy.exception.InvalidDataException;
import org.example.dummy.service.NumberService;
import org.example.dummy.utility.NumberHelper;
import org.example.dummy.utility.Response;
import org.example.dummy.utility.Response.CustomError;
import org.example.dummy.utility.Response.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;

/***
 * 
 * @author sadekrahman This is a resource class for Number Utility. Currently
 *         supports only Fibannci Number
 *
 */
@RestController
@RequestMapping("/number")
@Api(value = "NumberUtil", tags = "REQ [ 3 ] Number Utility API")
public class NumberUtilityResource {

	private static Long MAX_FIBO = 2500L;
	@Autowired
	NumberService numberService;

	/**
	 * 
	 * @param fiboNumber
	 * @return
	 * 
	 * 		Returns array with the first N Fibonacci numbers.
	 * 
	 */
	@RequestMapping(value = "/fibonacci/{fiboNumber}", method = RequestMethod.POST)
	public Response getFiboArray(@PathVariable(value = "fiboNumber") String fiboNumber) {

		try {
			verify(fiboNumber);
			return new Response(Status.OK, numberService.getFibonacci(Long.parseLong(fiboNumber)), null);
		} catch (InvalidDataException e) {
			return new Response(Status.ERROR, null, new CustomError(404, e.getMessage()));
		} catch (IllegalArgumentException e) {
			return new Response(Status.ERROR, null, new CustomError(404, e.getMessage()));
		}

	}

	/**
	 * Check Number is valid or Number is too large
	 * 
	 * @param fiboNumber
	 * @throws InvalidDataException
	 */
	private void verify(String fiboNumber) throws InvalidDataException {

		if (!NumberHelper.isInteger(fiboNumber)) {
			throw new InvalidDataException("Invalid Number");

		}
		if (Long.parseLong(fiboNumber) < 0) {
			throw new IllegalArgumentException("For Fibonacci Number Can't be less than 0.");
		}

		if (Long.parseLong(fiboNumber) > MAX_FIBO) {
			throw new InvalidDataException("Data Too Large to proess");
		}
	}

}
