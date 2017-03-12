package com.algorithms.problems.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	private PascalTriangle() {
	}

	public static void main(String[] args) {

		generatePascalTriangle(10).forEach(System.out::println);

	}

	/**
	 * Pascal Triangle:
	 * 
	 * <pre>
	 * 
	 * 		1
	 * 	   1 1
	 *    1 2 1
	 *   1 3 3 1
	 *  1 4 6 4 1
	 * 
	 * </pre>
	 * 
	 * @param rows
	 *            - number of rows to generate triangle
	 * @return - ArrayList having the pascal triangle
	 */

	public static List<List<Integer>> generatePascalTriangle(int rows) {

		List<List<Integer>> pascalTriangle = new ArrayList<>();
		for (int i = 0; i < rows; i++) {

			List<Integer> currentRow = new ArrayList<>();
			for (int j = 0; j <= i; j++) {

				currentRow.add(
						j > 0 && i > j ? pascalTriangle.get(i - 1).get(j - 1) + pascalTriangle.get(i - 1).get(j) : 1);

			}

			pascalTriangle.add(currentRow);

		}

		return pascalTriangle;

	}

}
