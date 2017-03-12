package com.algorithms.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ArrayApp {

	private ArrayApp() {
	}

	public static void main(String[] args) {

		randomPermutations(10).forEach((i) -> System.out.print(i + " "));

	}

	/**
	 * Example:
	 * 
	 * <pre>
	 * 	1  2  3  4 
	 *	5  6  7  8 
	 *	9  10 11 12 
	 *	13 14 15 16
	 * </pre>
	 * 
	 * @param s
	 * @return
	 */
	public static String[][] flipArray(String[][] s) {

		if (s == null)
			return null;

		for (int i = 0; i < s.length / 2; ++i) {

			for (int j = i; j < s.length - i - 1; ++j) {

				String temp = s[i][j];

				// left down -> top left
				s[i][j] = s[s.length - 1 - j][i];

				// down right -> left down
				s[s.length - 1 - j][i] = s[s.length - 1 - i][s.length - 1 - j];

				// top right -> down right
				s[s.length - 1 - i][s.length - 1 - j] = s[j][s.length - 1 - i];

				// top left -> top right
				s[j][s.length - 1 - i] = temp;

			}

		}

		return s;

	}

	public static int deleteDuplicates(List<Integer> list) {

		if (list.isEmpty())
			return 0;

		list.sort((a, b) -> a - b);
		System.out.println(list.get(3));
		list.forEach(System.out::print);
		// 1,4,5,6,6,7
		int writeIndex = 1;
		for (int i = 1; i < list.size(); ++i) {
			if (!list.get(i - 1).equals(list.get(i))) {
				list.set(writeIndex++, list.get(i));
			}
		}

		list.forEach(System.out::print);
		return writeIndex;

	}

	/**
	 * 
	 * @param num1
	 *            - List a
	 * @param num2
	 *            - List b
	 * @return - product of lists
	 */
	public static List<Integer> multiply(List<Integer> num1, List<Integer> num2) {

		final int sign = num1.get(0) < 0 ^ num2.get(0) < 0 ? -1 : 1;
		num1.set(0, Math.abs(num1.get(0)));
		num2.set(0, Math.abs(num2.get(0)));

		List<Integer> result = new ArrayList<>(Collections.nCopies(num1.size() + num2.size(), 0));

		for (int i = num1.size() - 1; i >= 0; --i) {
			for (int j = num2.size() - 1; j >= 0; --j) {
				result.set(i + j + 1, result.get(i + j + 1) + num1.get(i) * num2.get(j));
				result.set(i + j, result.get(i + j) + result.get(1 + j + 1) / 10);
				result.set(i + j + 1, result.get(i + j + 1) % 10);
			}

		}

		// Remove leading zeros
		int firstNonZero = 0;
		while (firstNonZero < result.size() && result.get(firstNonZero) == 0) {
			++firstNonZero;
		}

		result = result.subList(firstNonZero, result.size());
		if (result.isEmpty()) {
			return Arrays.asList(0);
		}

		result.set(0, result.get(0) * sign);

		result.forEach(System.out::println);

		return result;

	}

	/**
	 * 
	 * @param a
	 *            - integer array as {1,5,6} -> {1,5,7}
	 * @return - updated array with D + 1
	 */

	public static List<Integer> plusOne(List<Integer> a) {

		int n = a.size() - 1;
		a.set(n, a.get(n) + 1);

		for (int i = n; i > 0 && a.get(i) == 10; i--) {
			a.set(i, 0);
			a.set(i - 1, a.get(i - 1) + 1);
		}

		if (a.get(0) == 10) {
			a.set(0, 0);
			a.add(0, 1);
		}

		return a;
	}

	public static double computeMaxProfit(List<Double> prices) {
		double minPrice = Double.MAX_VALUE;
		double maxProfit = 0.0;

		for (Double price : prices) {
			maxProfit = Math.max(maxProfit, price - minPrice);
			minPrice = Math.min(minPrice, price);
		}
		return maxProfit;
	}

	public static double buyAndSellStockTwice(List<Double> prices) {

		double maxTotalProfit = 0.0;
		List<Double> firstBuySellProfits = new ArrayList<>();
		double minPricesSoFar = Double.MAX_VALUE;

		for (int i = 0; i < prices.size(); i++) {

			minPricesSoFar = Math.min(minPricesSoFar, prices.get(i));
			maxTotalProfit = Math.max(maxTotalProfit, prices.get(i) - minPricesSoFar);
			firstBuySellProfits.add(maxTotalProfit);

		}

		double maxPricesSoFar = Double.MIN_VALUE;

		for (int i = prices.size() - 1; i > 0; i--) {
			maxPricesSoFar = Math.max(maxPricesSoFar, prices.get(i));
			maxTotalProfit = Math.max(maxTotalProfit, maxPricesSoFar) - prices.get(i) + firstBuySellProfits.get(i - 1);
		}

		return maxTotalProfit;
	}

	public static List<Integer> generatePrimes(int n) {

		List<Integer> primes = new ArrayList<>();

		List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(n + 1, true));
		isPrime.set(0, false);
		isPrime.set(1, false);

		for (int p = 2; p <= n; ++p) {
			if (isPrime.get(p)) {

				primes.add(p);

				for (int j = p; j <= n; j += p) {

					isPrime.set(j, false);

				}

			}

		}
		return primes;
	}

	public static List<Integer> randomPermutations(int n) {

		List<Integer> integers = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			integers.add(i);
		}

		Random random = new Random();
		for (int i = 0; i < n; i++) {
			Collections.swap(integers, i, random.nextInt(integers.size() - 1));
		}

		return integers;
	}

}
