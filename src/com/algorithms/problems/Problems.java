package com.algorithms.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * General Problems
 * 
 * @author saldivar
 *
 */
public class Problems {

	private Problems() {
	}

	public static void main(String[] args) {

		String[] a = { "z", "b", "x" };
		String[] b = { "a", "b", "a" };

		System.out.println("Check pattern: " + checkPattern(a, b));

		int[] z = { 9, 9, 9, 9, 20, 1, 19, 18, 2, 2, 17, 3, 3, 3 };
		System.out.println("Number of pairs: " + numberOfPairs(z, 20));

		String[] x = { "apple", "eppla", "apple" };
		System.out.println("Check not same word: " + checkNotSame(x));

		System.out.println("Get same letters: " + getSameLetters("applxe", "pineiapple"));

	}

	/**
	 * Check if the 2 arrays follow the same pattern:
	 * 
	 * <pre>
	 * Return True:
	 * 		a b a
	 * 		z b z
	 * 		
	 * Return False:
	 * 		a b a
	 * 		z b x
	 * 
	 * </pre>
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean checkPattern(String[] a, String[] b) {

		if (a == null && b == null) {
			return true;
		} else if (a == null || b == null) {
			return false;
		}

		Map<String, Integer> aSet = new HashMap<>();
		Map<String, Integer> bSet = new HashMap<>();

		int aCounter = 0;
		int bCounter = 0;

		StringBuilder patternA = new StringBuilder();
		StringBuilder patternB = new StringBuilder();

		for (int i = 0; i < a.length; i++) {

			if (aSet.get(a[i]) == null)
				aSet.put(a[i], ++aCounter);

			if (bSet.get(b[i]) == null)
				bSet.put(b[i], ++bCounter);

			patternA.append(aSet.get(a[i]));
			patternB.append(bSet.get(b[i]));

		}

		return patternA.toString().equals(patternB.toString());

	}

	/**
	 * Check which is the letter which is not the same. Constraint. If 3, 2
	 * words need to have the same letters Example: apple elppa elappi return
	 * "i"
	 * 
	 * @param a
	 * @return
	 */
	public static String checkNotSame(String[] a) {

		StringBuilder firstPattern = new StringBuilder();
		StringBuilder secondPattern = new StringBuilder();

		char[] firstWord = a[0].toCharArray();
		char[] secondWord = a[1].toCharArray();
		Arrays.sort(firstWord);
		Arrays.sort(secondWord);

		// Remove duplicate letters from first sorted word
		firstPattern.append(firstWord[0]);
		for (int i = 1; i < firstWord.length; i++) {
			if (firstWord[i - 1] != firstWord[i]) {
				firstPattern.append(firstWord[i]);
			}
		}

		// Remove duplicate letters from second sorted word
		secondPattern.append(secondWord[0]);
		for (int i = 1; i < secondWord.length; i++) {
			if (secondWord[i - 1] != secondWord[i]) {
				secondPattern.append(secondWord[i]);
			}
		}

		String pattern;
		if (firstPattern.length() < secondPattern.length()) {
			pattern = firstPattern.toString();
		} else {
			pattern = secondPattern.toString();
		}

		for (int i = 0; i < a.length; i++) {
			String temp = a[i].replaceAll("[" + pattern + "]", "");
			if (!"".equals(temp))
				return temp;
		}

		return "They all have the same words";

	}

	/**
	 * Get the same letters that intersect between each other
	 * Example: apple - pineapple. Results: aelp
	 * @param a
	 * @param b
	 * @return
	 */
	public static String getSameLetters(String a, String b) {

		Set<Character> matchingLetters = new HashSet<>();

		if (a.length() > b.length()) {

			for (int i = 0; i < b.length(); i++) {

				if (a.indexOf(b.charAt(i)) >= 0) {
					matchingLetters.add(b.charAt(i));
				}

			}

		} else {

			for (int i = 0; i < a.length(); i++) {

				if (b.indexOf(a.charAt(i)) >= 0) {
					matchingLetters.add(a.charAt(i));
				}

			}

		}

		return matchingLetters.toString();
	}

	/**
	 * a = {9,9,9,9, 20, 1, 19, 18, 2, 2, 17, 3, 3, 3}; k = 20 result = 3
	 * 
	 * @param a
	 * @param k
	 * @return
	 */
	public static int numberOfPairs(int[] a, long k) {

		int unique = 0;
		Map<Integer, Boolean> map = new HashMap<>();

		for (int i = 0; i < a.length; i++) {

			if (map.put(a[i], false) != null)
				map.put(a[i], true);
			else
				map.put(a[i], false);

		}

		Iterator<Entry<Integer, Boolean>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {

			Map.Entry<Integer, Boolean> mapValue = iterator.next();

			int complement = (int) k - (int) mapValue.getKey();

			if (map.get(complement) != null && ((complement == (int) mapValue.getKey() && (boolean) mapValue.getValue())
					|| complement != (int) mapValue.getKey())) {
				map.put((int) mapValue.getKey(), null);
				unique++;
			}
		}

		return unique;

	}

}
