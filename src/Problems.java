
public class Problems {

	public void run() {
		String compression = "aaabbccc";
		String compressedString = compress(compression);
		
		if (compression.length() <= compressedString.length()) {
			System.out.println(compression);
		} else {
			System.out.println(compressedString);
		}
		

		

		/*
		 * String one = "abvc"; String two = "bcav";
		 * 
		 * if(one.length() != two.length()) { return; }
		 * 
		 * if(sort(one).equals(sort(two))) System.out.println("Permuted"); else
		 * System.out.println("");
		 */
	}

	String compress (String compression) {
		
		StringBuilder newString = new StringBuilder();
		char a = compression.charAt(0);
		int charCount = 1;
		
		for (int i = 1; i < compression.length(); i++) {
			
			if (a == compression.charAt(i)) {
				charCount++;
				continue;
			} else {
				newString.append(String.valueOf(a) + charCount);
			} 
			
			charCount = 1;
			a = compression.charAt(i);
			
		}
		
			newString.append(String.valueOf(a) + charCount);
	
		
		return newString.toString();
	}

	void replacesSpaces(char[] str, int trueLength) {
		int spaceCount = 0;
		int index;
		int i;

		for (i = 0; i < trueLength; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}

		index = trueLength + spaceCount * 2;
		if (trueLength < str.length)
			str[trueLength] = '\0';

		for (i = trueLength - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[index - 1] = '0';
				str[index - 2] = '2';
				str[index - 3] = '%';
				index = index - 3;
			} else {
				str[index - 1] = str[i];
				index--;
			}

		}
	}

	String sort(String s) {
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
	}

}
