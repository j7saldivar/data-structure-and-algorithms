package com.algorithms.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrixOrder {

	private SpiralMatrixOrder() {
	}

	public static void main(String[] args) {

		List<List<Integer>> matrix = new ArrayList<>();

		matrix.add(Arrays.asList(1, 2, 3, 4, 50));
		matrix.add(Arrays.asList(5, 6, 7, 8, 51));
		matrix.add(Arrays.asList(9, 10, 11, 12, 52));
		matrix.add(Arrays.asList(13, 14, 15, 16, 53));
		matrix.add(Arrays.asList(17, 18, 19, 20, 54));

		matrixInSpiralOrder(matrix).forEach(i -> System.out.print(i + " "));

	}

	public static List<Integer> matrixInSpiralOrder(List<List<Integer>> matrix) {

		List<Integer> spiralOrder = new ArrayList<>();
		int maxSize = (int) Math.ceil(matrix.size() * 0.5);

		for (int offset = 0; offset < maxSize; ++offset) {
			followSpiral(matrix, offset, spiralOrder);
		}

		return spiralOrder;
	}

	private static void followSpiral(List<List<Integer>> matrix, int offset, List<Integer> spiralOrder) {

		// center for odd matrix
		if (offset == matrix.size() - offset - 1) {
			spiralOrder.add(matrix.get(offset).get(offset));
			return;
		}

		// left -> right
		for (int i = offset; i < matrix.size() - offset; i++) {
			spiralOrder.add(matrix.get(offset).get(i));
		}

		// right -> down
		for (int i = offset + 1; i < matrix.size() - offset; i++) {
			spiralOrder.add(matrix.get(i).get(matrix.size() - offset - 1));
		}

		// down -> left
		for (int i = matrix.size() - 2 - offset; i >= offset; i--) {
			spiralOrder.add(matrix.get(matrix.size() - offset - 1).get(i));
		}

		// left -> up
		for (int i = matrix.size() - 2 - offset; i > offset; i--) {
			spiralOrder.add(matrix.get(i).get(offset));
		}

	}

}
