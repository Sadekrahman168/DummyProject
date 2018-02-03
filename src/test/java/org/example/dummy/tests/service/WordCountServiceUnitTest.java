package org.example.dummy.tests.service;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import java.util.Map;
import org.example.dummy.impl.WordCountServiceImpl;
import org.hamcrest.collection.IsMapContaining;

/**
 * Test WordCountService. Test processing large String and finding out unique
 * counts.
 * 
 * @author sadekrahman
 *
 */
public class WordCountServiceUnitTest {

	WordCountServiceImpl wordCountService;
	String smallText = "Hello world hello";

	@Before
	public void setup() {
		wordCountService = new WordCountServiceImpl();
	}

	@Test
	public void testGetCountForSmallText() {

		Map<String, Integer> actual = wordCountService.getWordCounts(smallText, "asc");

		// == Verify Size
		assertThat(actual.size(), is(2));
		// == Check both the word Exist.
		assertThat(actual, IsMapContaining.hasKey("hello"));
		assertThat(actual, IsMapContaining.hasKey("world"));
		// == Hello Should have 2 occurrence
		assertThat(actual, IsMapContaining.hasEntry("hello", 2));
		// == world should have 1 occurrence
		assertThat(actual, IsMapContaining.hasEntry("world", 1));

	}

}
