/*
 * Solution to Chapter1 Problem1.4
 */
class Solution04 {
	public static void main(String[] args) {
		String a = "ab cd cd";
		String b = "cc bd bd";
		String c = "ddcb dcd";

		if (isPlaindromePermutation2(a))
			System.out.println("a is palindrome permutation");
		if (isPlaindromePermutation2(b))
			System.out.println("b is palindrome permutation");
		if (isPlaindromePermutation2(c))
			System.out.println("c is palindrome permutation");

	}

	/*
	 * This method uses an array to count the number of different character and
	 * make an judgement basing on the fact that a plaindrome can only allow at
	 * most one character has odd number
	 */
	public static boolean isPlaindromePermutation(String s) {
		int[] charnum = new int[26];
		int oddcount = 0;
		for (int i = 0; i < s.length(); i++) {
			if (getCharNum(s.charAt(i)) != -1) {
				charnum[getCharNum(s.charAt(i))]++;
				if (charnum[getCharNum(s.charAt(i))] % 2 == 1)
					oddcount++;
				else
					oddcount--;
			}
		}
		return oddcount <= 1;
	}

	
	public static boolean isPlaindromePermutation2(String s) {         
		int bitvector = 0;
		for (char c : s.toCharArray()) {
						if (getCharNum(c) >= 0) {
				if ((bitvector & (1 << getCharNum(c))) >0){     //（not == 1) 
					bitvector &= ~(1 << getCharNum(c));
				} else
					bitvector |= (1 << getCharNum(c));
			}
		}
		if ((bitvector == 0)|| ((bitvector & (bitvector - 1))==0)) return true;
		return false;
	}
	
	public static int getCharNum(Character c) {
		// case insensitive
		if (c >= 'a' && c <= 'z')
			return (c - 'a');
		if (c >= 'A' && c <= 'Z')
			return (c - 'A');
		return -1; // other condition like a blank;

	}


}
