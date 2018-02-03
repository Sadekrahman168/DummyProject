package org.example.dummy.tests.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import org.example.dummy.impl.ExternalServiceImpl;

/**
 * This class is responsible to do unit test on ExternalService
 * 
 * @author sadekrahman
 *
 */
@RunWith(SpringRunner.class)
@TestPropertySource("classpath:test-application.properties")
public class ExternalServiceUnitTest {

	ExternalServiceImpl externalService;

	@Value("${public.api.jsonplaceholder.baseuri}")
	private String BASE_URI;

	@Before
	public void setUp() {
		externalService = new ExternalServiceImpl();
		externalService.setBASE_URI(BASE_URI);
	}

	/**
	 * Test, get all posts from External service.
	 */
	@Test
	public void testGetContentAllPosts() {
		Object response = externalService.getContent("");
		assertThat(StringUtils.countOccurrencesOf(response.toString(), "userId") > 1);

	}

	/**
	 * Test, get / query for a Single post.
	 * 
	 */
	@Test
	public void testGetContentSinglePost() {
		Object response = externalService.getContent("?id=1");
		assertEquals((StringUtils.countOccurrencesOf(response.toString(), "userId")), 1);

	}

}
