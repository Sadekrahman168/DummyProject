package org.example.dummy.impl;


import java.util.List;
import org.example.dummy.service.NumberService;
import org.example.dummy.utility.NumberHelper;
import org.springframework.stereotype.Service;

/**
 * A Classs to calculate Fibonacci Number.
 * 
 * @author sadekrahman
 *
 */
@Service
public class NumberServiceImpl implements NumberService {

	private static final int _MAX_BUFEER_FOR_RECURSION = 45;

	/**
	 * Return N fibonacci Numbers. Special precaution has been taken to avoid
	 * STACK-OVEARFLOW issue on recursive method. An iterative method will handle the
	 * calculation If number is too big to handle by the recursive
	 * 
	 */
	@Override
	public List<Long> getFibonacci(long number) {
		/*
		 * TODO: Configure EhCache to get previously solved data
		 * 
		 */
		// == If Number is too large don't call recursive function. call an iterative
		// method.
		if (number > _MAX_BUFEER_FOR_RECURSION) {
			return NumberHelper.getFiboListNonRecursive(number);
		} else {
			return NumberHelper.getFiboList(number);
		}

	}

}
