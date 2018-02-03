package org.example.dummy.tests.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Test Suite for All ServiceTest cases.
 * 
 * @author sadekrahman
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	CityServiceUnitTest.class,
	ConsumerProducerServiceUnitTest.class,
	ExternalServiceUnitTest.class,
	HelloWorldServiceUnitTest.class,
	NumberServiceUnitTest.class,
	WordCountServiceUnitTest.class
})
public class AllServiceTestSuit {

}
