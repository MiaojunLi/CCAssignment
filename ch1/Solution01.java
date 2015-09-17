/*
 * Solution to Chapter1 Problem1.1
 */
public class Solution01 {

	public static void main(String[] args) {
		String s = "abcd";
		String s1 = "abcdcf";
		String s2 = "Abdfa";
		if (isUnique1(s))
			System.out.println("yes1");
		if (isUnique1(s1))
			System.out.println("yes2");
		if (isUnique2(s))
			System.out.println("yes3");
		if (isUnique2(s1))
			System.out.println("yes4");
		if (isUnique2(s2))
			System.out.println("yes5");
	}

	/*
	 * Solution1: Use bit vector without extra data structures Assume the string
	 * only uses lowercase;But it can also be changed to uppercase
	 */
	public static boolean isUnique1(String s) {
		int bitcheck = 0;
		for (int i = 0; i < s.length(); i++) {
			// The same character will set the same bit,and '&' operation
			// indicates unique if all bit is 0;
			if ((bitcheck & (1 << (s.charAt(i) - 'a'))) > 0) {
				return false;
			}
			bitcheck |= 1 << (s.charAt(i) - 'a');
		}
		return true;
	}

	/*
	 * Solution2: Use an array of boolean value, different character will have
	 * different place in the array because its ASCII code
	 */
	public static boolean isUnique2(String s) {
		boolean[] charSet = new boolean[256]; // default false
		for (int i = 0; i < s.length(); i++) {
			if (charSet[s.charAt(i)]) // if true, it means the character appear twice
				return false;
			charSet[s.charAt(i)] = true; // else, set it 'true' to indicate it has appear
		}
		return true;
	}
}
