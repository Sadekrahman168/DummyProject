package org.example.dummy.tests.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.example.dummy.dto.MessageDTO;
import org.example.dummy.impl.HelloWorldServiceImpl;
import org.example.dummy.model.City;
import org.example.dummy.model.Message;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

/**
 * Test, HelloWorldServiceImpl class.
 * 
 * @author sadekrahman
 *
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class HelloWorldServiceUnitTest {

	@Mock
	HelloWorldServiceImpl helloWorldService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

	}

	/**
	 * Unit Test for GetGreeting method.
	 */
	@Test
	public void testGetGreeting() {
		when(helloWorldService.getGreeting()).thenReturn(new MessageDTO(new Message("Hello World")));
		MessageDTO greeting = helloWorldService.getGreeting();
		assertEquals(greeting.getText(), "Hello World");
	}

}
