package com.algorithms.recursion;

class Recursion {
	
	private Recursion() {}

	/*
	 * Fibonacci series:
	 * Number:	0,1,2,3,4,5,6, 7, 8
	 * Results: 0,1,1,2,3,5,8,13,21
	 */
	
	static int fibonacci(int number) {

		if (number < 0)
			return 0;
		else if (number == 0 || number == 1)
			return number;
		else {
			return fibonacci(number - 2) + fibonacci(number - 1);
		}

	}

	static double goldenRatio(int number) {
		return (fibonacci(number) * 1.0) / Recursion.fibonacci(number - 1);
	}
}
