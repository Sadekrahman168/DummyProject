package org.example.dummy.resources;

import org.example.dummy.exception.NotFoundException;
import org.example.dummy.service.ExternalService;
import org.example.dummy.utility.Response;
import org.example.dummy.utility.Response.CustomError;
import org.example.dummy.utility.Response.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;

/**
 * Make REST calls to external API
 * 
 * @author sadekrahman
 *
 */
@RestController
@RequestMapping("/externaldata")
@Api(value = "External API", tags = "REQ [ 6 ] External API")
public class ExternalDataResource {

	@Autowired
	ExternalService externalService;

	/**
	 * Returns all The Entity from External API.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Response getPosts() {
		try {
			return new Response(Status.OK, externalService.getContent(""), null);
		} catch (NotFoundException e) {
			return new Response(Status.ERROR, null, new CustomError(404, "Nothing Found "));
		}
	}

	/**
	 * Returns single POST based on id provided.
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(path = "post/{id}", method = RequestMethod.GET)
	public Response getPostById(@PathVariable(value = "id") String id) {
		try {
			return new Response(Status.OK, externalService.getContent("?id=" + id), null);
		} catch (NotFoundException e) {
			return new Response(Status.ERROR, null, new CustomError(404, "Nothing Found "));
		}

	}

	/**
	 * Returns N number of POST based on userid
	 * 
	 * @param id
	 * @return
	 */

	@RequestMapping(path = "posts/{userid}", method = RequestMethod.GET)
	public Response getPostByUserId(@PathVariable(value = "userid") String id) {
		try {
			return new Response(Status.OK, externalService.getContent("?userId=" + id), null);
		} catch (NotFoundException e) {
			return new Response(Status.ERROR, null, new CustomError(404, "Nothing Found "));
		}

	}

}
