package com.algorithms.draft;

public class PrimaryTypes {

	public static short countNumberOfBitsOn(int x) {

		System.out.println("Binary num   : " + Integer.toBinaryString(x));
		short numBits = 0;

		while (x != 0) {

			numBits += (x & 1);
			x >>>= 1;
			System.out.println("Right shifted: " + Integer.toBinaryString(x));

		}

		System.out.println("Result: " + numBits);
		return numBits;
	}

	// O (n)
	public static short parity(int x) {

		short parityFlag = 0;

		while (x != 0) {

			System.out.print("Binary:  " + Integer.toBinaryString(x));
			parityFlag ^= (x & 1);
			System.out.println(" \t\t: Parity Flag: " + parityFlag);
			x >>>= 1;

		}

		System.out.println("Result:  " + parityFlag);
		return parityFlag;
	}

	// O (log n)
	public static short parityOptimized(long x) {

		x ^= x >>> 32;
		x ^= x >>> 16;
		x ^= x >>> 8;
		x ^= x >>> 4;
		x ^= x >>> 2;
		x ^= x >>> 1;

		return (short) (x & 0x1);

	}

	/*- Sample number: 129
	 *  Binary: 	   1000 0001
	 * 	Flip position  0 and 6
	 *
	 *	   			0000 0001
	 * 		I XOR J	0100 0000		
	 *   XOR RESULT	0100 0001
	 * RESULT XOR X 1000 0001
	 *        FINAL 1100 0000
	**/
	public static long swapBits(long x, int i, int j) {

		if (((x >>> i) & 1) != ((x >>> j) & 1)) {
			// Flip XOR
			long bitMask = (1L << i) | (1L << j);
			x ^= bitMask;

		}

		return x;

	}

	public static void main(String[] args) {

		short num = 129;
		System.out.println("Number: " + num + " \nBinary num: " + Integer.toBinaryString(num));

		System.out.println("\nCount Number of Bits On: ");
		countNumberOfBitsOn(num);

		System.out.println();
		System.out.println("Check Parity:");
		parity(num);

		System.out.println();
		System.out.println("Check Parity Optimized: " + parityOptimized(num));

		System.out.println();
		System.out.println("Binary to be swapped: " + Integer.toBinaryString(num));
		System.out.println("Binary number swapped: " + Long.toBinaryString(swapBits(num, 0, 6)));

	}

}
