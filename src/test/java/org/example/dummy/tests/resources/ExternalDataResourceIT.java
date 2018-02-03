package org.example.dummy.tests.resources;

import static org.assertj.core.api.Assertions.assertThat;

import org.example.dummy.resources.ExternalDataResource;
import org.example.dummy.utility.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

/**
 * 
 * Test External REST API calls
 * 
 * @author sadekrahman
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ExternalDataResourceIT {

	@Autowired
	ExternalDataResource externalDataResource;

	/**
	 * Test for GetAll Post
	 * 
	 */
	@Test
	public void testGetPosts() {
		Response posts = externalDataResource.getPosts();
		assertThat(StringUtils.countOccurrencesOf(posts.getData().toString(), "userId") > 1);

	}

	/**
	 * Test, get / query for a Single post using postID
	 * 
	 */
	@Test
	public void testGetPostById() {
		Response posts = externalDataResource.getPostById("1");
		assertThat(StringUtils.countOccurrencesOf(posts.getData().toString(), "userId") == 1);

	}

	/**
	 * Test, get / query for posts using userID
	 * 
	 */

	@Test
	public void testGetPostByUserId() {
		Response posts = externalDataResource.getPostByUserId("1");
		assertThat(StringUtils.countOccurrencesOf(posts.getData().toString(), "userId") >= 1);

	}

}
