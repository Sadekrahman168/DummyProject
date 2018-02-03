package org.example.dummy.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.lang.Math.toIntExact;

/**
 * Helper method to provide different Number utility methods.
 * 
 * @author sadekrahman
 *
 */
public class NumberHelper {

	/**
	 * A recursive method to solve Fibonacci series.
	 * 
	 * @param number
	 * @return
	 */
	public static long getFibonacci(long number) {
		if ((number == 0) || (number == 1))
			return number;
		else
			return getFibonacci(number - 1) + getFibonacci(number - 2);
	}

	public static List<Long> getFiboList(long number) {
		List<Long> results = new ArrayList<>();
		for (int i = 0; i <= number; i++) {
			results.add((Long) getFibonacci(i));
		}
		return results;
	}

	/***
	 * Solve Fibonacci in iterative way.
	 * 
	 * @param number
	 * @return
	 */
	public static List<Long> getFiboListNonRecursive(long number) {

		if (number == 0) {
			return new ArrayList<Long>();
		}

		if (number == 1) {
			return Arrays.asList(1L);
		}

		if (number == 2) {
			return Arrays.asList(0L, 1L);
		}

		final List<Long> resultList = new ArrayList<>(toIntExact(number));
		resultList.add(0L);
		number = number - 1;
		resultList.add(1L);
		number = number - 1;

		while (number > 1) {

			resultList.add(resultList.get(resultList.size() - 1) + resultList.get(resultList.size() - 2));
			number = number - 1;
		}

		return resultList;
	}

	public static boolean isInteger(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
