package org.example.dummy.resources;

import org.example.dummy.exception.NotFoundException;
import org.example.dummy.service.HelloWorldService;
import org.example.dummy.utility.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.example.dummy.utility.Response.Status;
import org.example.dummy.utility.Response.CustomError;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/***
 * 
 * @author sadekrahman Resource/Controller class to handle Hello World messages
 *
 */
@RestController
@RequestMapping("/hello")
@Api(value = "Hello", tags = "REQ [ 1 ] Hello World API")
public class HelloWorldResource {

	@Autowired
	HelloWorldService helloWorldService;

	/**
	 * Default route for this Resource, Will simply return 'Hello World to end user'
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Get Hello", response = String.class)
	public Response getHello() {
		try {
			return new Response(Status.OK, helloWorldService.getGreeting().getText(), null);
		} catch (NotFoundException e) {
			return new Response(Status.ERROR, null, new CustomError(404, "Nothing Found "));
		}
	}

	// TODO: Demonstrate API versioniing with a new Method.

}
