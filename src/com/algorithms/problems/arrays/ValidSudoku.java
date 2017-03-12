package com.algorithms.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ValidSudoku {

	private ValidSudoku() {
	}

	public static void main(String[] args) {

		List<List<Integer>> sudoku = new ArrayList<>();

		sudoku.add(Arrays.asList(5, 3, 4, 6, 7, 8, 9, 1, 2));
		sudoku.add(Arrays.asList(6, 7, 2, 1, 9, 5, 3, 4, 8));
		sudoku.add(Arrays.asList(1, 9, 8, 3, 4, 2, 5, 6, 7));

		sudoku.add(Arrays.asList(8, 5, 9, 7, 6, 1, 4, 2, 3));
		sudoku.add(Arrays.asList(4, 2, 6, 8, 5, 3, 7, 9, 1));
		sudoku.add(Arrays.asList(7, 1, 3, 9, 2, 4, 8, 5, 6));

		sudoku.add(Arrays.asList(9, 6, 1, 5, 3, 7, 2, 8, 4));
		sudoku.add(Arrays.asList(2, 8, 7, 4, 1, 9, 6, 3, 5));
		sudoku.add(Arrays.asList(3, 4, 5, 2, 8, 6, 1, 7, 9));

		sudoku.forEach(System.out::println);

		System.out.println("\nIs valid sudoku: " + isValidSudoku(sudoku));

	}

	public static boolean isValidSudoku(List<List<Integer>> partialAssignment) {

		// Check Rows
		for (int i = 0; i < partialAssignment.size(); i++) {

			if (hasDuplicate(partialAssignment, i, i + 1, 0, partialAssignment.size())) {
				return false;
			}

		}

		// Check Columns
		for (int j = 0; j < partialAssignment.size(); j++) {

			if (hasDuplicate(partialAssignment, 0, partialAssignment.size(), j, j + 1)) {
				return false;
			}

		}

		int regionSize = (int) Math.sqrt(partialAssignment.size());
		// Check regions
		for (int i = 0; i < regionSize; i++) {
			for (int j = 0; j < regionSize; j++) {

				if (hasDuplicate(partialAssignment, regionSize * i, regionSize * (i + 1), regionSize * j,
						regionSize * (j + 1))) {
					return false;
				}

			}
		}
		return true;
	}

	private static boolean hasDuplicate(List<List<Integer>> partialAssignment, int startRow, int endRow, int startCol,
			int endCol) {

		List<Boolean> isPresent = new ArrayList<>(Collections.nCopies(partialAssignment.size() + 1, false));
		for (int i = startRow; i < endRow; i++) {
			for (int j = startCol; j < endCol; j++) {

				if (partialAssignment.get(i).get(j) != 0 && isPresent.get(partialAssignment.get(i).get(j))) {
					return true;
				}
				isPresent.set(partialAssignment.get(i).get(j), true);
			}
		}
		return false;
	}

}
