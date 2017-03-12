package com.algorithms.recursion;

class RecursionApp {
	
	RecursionApp() {}

	public static void main(String[] args) {

		int number = 50;
		System.out.println("Input: " + number);
		System.out.println("Fibonacci: " + Recursion.fibonacci(number));
		System.out.println("Golden Ratio: " + Recursion.goldenRatio(number));

	}
}
