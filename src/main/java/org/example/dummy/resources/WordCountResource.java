package org.example.dummy.resources;

import org.example.dummy.service.WordCountService;
import org.example.dummy.utility.Response;
import org.example.dummy.utility.Response.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;

/**
 * Controller for Word Counts.
 * 
 * @author sadekrahman
 *
 */
@RestController
@RequestMapping("/count")
@Api(value = "Frequncey", tags = "REQ [ 2 ] Frequency processing API")
public class WordCountResource {

	@Autowired
	WordCountService wordCountService;

	/**
	 * Count number of occurrences for different words on a given Text
	 * 
	 * @param sortDirection
	 * @param text
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public Response getWordCounts(
			@RequestParam(value = "sort", required = false, defaultValue = "asc") String sortDirection,
			@RequestBody String text) {
		return new Response(Status.OK, wordCountService.getWordCounts(text, sortDirection), null);

	}
}
