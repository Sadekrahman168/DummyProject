package org.example.dummy.tests.service;

import static org.junit.Assert.*;

import java.util.List;

import org.example.dummy.impl.NumberServiceImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * Test, NumberService class for valid and Invalid Fibonnacci Number.
 * 
 * @author sadekrahman
 *
 */
public class NumberServiceUnitTest {

	NumberServiceImpl numberServiceImpl;

	@Before
	public void setup() {
		numberServiceImpl = new NumberServiceImpl();

	}

	/**
	 * Test an small Number
	 * 
	 */
	@Test
	public void testForValidFiboNacciNumber() {
		List<Long> fibonacci = numberServiceImpl.getFibonacci(0);
		assertEquals(0, fibonacci.get(0).longValue());
	}
	
	

	/**
	 * Test moderately Large number.
	 * 
	 */
	@Test
	public void testForValidFiboNacciNumber10() {
		List<Long> fibonacci = numberServiceImpl.getFibonacci(10);
		assertEquals(11, fibonacci.size());
	}

	/**
	 * Test Large Number. it might pause the process for a bit.
	 * 
	 */
	@Test
	public void testForValidLargeFiboNacciNumber() {
		List<Long> fibonacci = numberServiceImpl.getFibonacci(30);
		assertEquals(31, fibonacci.size());
	}

	/***
	 * Test for A invalid number.
	 * 
	 */
	@Test
	public void testForInValidNumber() {
		List<Long> fibonacci = numberServiceImpl.getFibonacci(-45);
		assertEquals(0, fibonacci.size());
	}
}
