package org.example.dummy.resources;

import org.example.dummy.service.ConsumerProducerService;
import org.example.dummy.utility.Response;
import org.example.dummy.utility.Response.CustomError;
import org.example.dummy.utility.Response.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Controller for DeadLock.
 * 
 * @author sadekrahman
 *
 */
@RestController
@RequestMapping("/producerconsumer")
@Api(value = "Consumer", tags = "REQ [ 4 ]  Consumer Producer API [ For deadlock ]")
public class ConsumerProducerResource {

	@Autowired
	ConsumerProducerService consumerProducerService;

	/**
	 * Upon calling this method a dead lock situation will arise.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "A deadlock API")
	public Response processDeadLock() {
		try {
			consumerProducerService.process();
			return new Response(Status.OK, null, null);
		} catch (Exception e) {
			return new Response(Status.ERROR, null, new CustomError(404, e.getMessage()));
		}
	}

}
