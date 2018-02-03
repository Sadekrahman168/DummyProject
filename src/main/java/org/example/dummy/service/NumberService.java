package org.example.dummy.service;

import java.util.List;

/**
 * calculate Fibonacci Number.
 * 
 * @author sadekrahman
 *
 */
public interface NumberService {
	/**
	 * Return N fibonacci Numbers as List
	 * 
	 * @param number
	 * @return
	 */
	List<Long> getFibonacci(long number);
}
