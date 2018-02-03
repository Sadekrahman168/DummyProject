package org.example.dummy.tests.resources;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import org.example.dummy.resources.NumberUtilityResource;
import org.example.dummy.utility.Response;
import org.example.dummy.utility.Response.Status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

/**
 * Test for Fibonacci Series.
 * 
 * @author sadekrahman
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class NumberUtilityResourceIT {

	@Autowired
	NumberUtilityResource numberUtilityResource;

	/**
	 * Test for a valid Fibonacci number.
	 * 
	 */
	@Test
	public void testGetFiboArray() {
		List<Long> actual = Arrays.asList(0L, 1L, 1L, 2L, 3L, 5L);
		Response posts = numberUtilityResource.getFiboArray("5");
		// == Check for Status.
		assertEquals(posts.getStatus(), Status.OK);
		// == Check for actual data.
		List<Long> expected = (List<Long>) posts.getData();
		assertThat(actual, is(expected));
		assertThat(actual, hasSize(6));

	}

	/**
	 * Check Exception for a Negative number.
	 * 
	 */
	@Test
	public void testGetFiboArrayInavlidNumber() {
		Response posts = numberUtilityResource.getFiboArray("-2");
		// == Check for Status.
		assertEquals(posts.getStatus(), Status.ERROR);
		// == Check for Error.
		assertEquals(posts.getError().getDescription(), "For Fibonacci Number Can't be less than 0.");

	}

}
