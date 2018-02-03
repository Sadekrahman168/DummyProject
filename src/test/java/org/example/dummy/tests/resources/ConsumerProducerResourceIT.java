package org.example.dummy.tests.resources;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.example.dummy.resources.ConsumerProducerResource;
import org.example.dummy.utility.Response;
import org.example.dummy.utility.Response.Status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Performs integration test on ConsumerProducerResource AKA deadllock Master.
 * 
 * @author sadekrahman
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ConsumerProducerResourceIT {

	@Autowired
	ConsumerProducerResource consumerProducerResource;

	/**
	 * Create and detect deadlock.
	 * 
	 */
	@Test
	public void testprocessDeadLock() {
		Response respone = consumerProducerResource.processDeadLock();
		// == Check for Error
		assertThat(respone.getStatus(), is(equalTo(Status.ERROR)));
		// == Check for DeadLock message.
		assertThat(respone.getError().getDescription(), is(equalTo("Deadlock detected!")));

	}

}
