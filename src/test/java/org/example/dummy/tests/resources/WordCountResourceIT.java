package org.example.dummy.tests.resources;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Map;

import org.example.dummy.resources.WordCountResource;
import org.example.dummy.utility.Response;
import org.example.dummy.utility.Response.Status;
import org.hamcrest.collection.IsMapContaining;

/**
 * Test word occurrences.
 * 
 * @author sadekrahman
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class WordCountResourceIT {

	private static final String SMALL_TEXT = "john doe foo bar and doe";
	@Autowired
	WordCountResource wordCountResource;

	/**
	 * Verify all the words and their occurrences after processing.
	 * 
	 */
	@Test
	public void testGetWordCounts() {
		Response response = wordCountResource.getWordCounts("asc", SMALL_TEXT);
		// == Check for Status.
		assertEquals(response.getStatus(), Status.OK);
		// == Verify Data
		Map<String, Integer> actual = (Map<String, Integer>) response.getData();
		// == Verify Size
		assertThat(actual.size(), is(5));
		// == Check both the word Exist.
		assertThat(actual, IsMapContaining.hasKey("john"));
		assertThat(actual, IsMapContaining.hasKey("foo"));
		// == Hello Should have 2 occurrence
		assertThat(actual, IsMapContaining.hasEntry("doe", 2));
		// == world should have 1 occurrence
		assertThat(actual, IsMapContaining.hasEntry("and", 1));

	}

}
