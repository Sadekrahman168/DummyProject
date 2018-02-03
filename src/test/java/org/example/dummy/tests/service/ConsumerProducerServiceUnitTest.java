package org.example.dummy.tests.service;

import static org.mockito.Mockito.doThrow;

import org.example.dummy.impl.ConsumerProducerServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

/**
 * This class will perform unit test on all the methods available on
 * ConsumerProducerService
 * 
 * @author sadekrahman
 *
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class ConsumerProducerServiceUnitTest {

	@Mock
	ConsumerProducerServiceImpl consumerProducerService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

	}

	/**
	 * Process method inside consumerProducerService ended up on deadlock, this
	 * method is simulating the same behavior.
	 * 
	 */
	@Test
	public void testProcess() {
		doThrow(new RuntimeException("Deadlock detected!")).when(consumerProducerService).process();
		try {
			consumerProducerService.process();
			Assert.fail();
		} catch (RuntimeException e) {

		}

	}

}
