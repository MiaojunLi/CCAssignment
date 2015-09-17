/*
 * Solution to Chapter1 Problem1.2
 *The easiest way to solve this problem is to sort the character array and compare 
 * the current one with next one, but taking efficiency into consideration, we can
 * use other method
 */
public class Solution02 {
	public static void main(String[] args) {
		String a = "abcd";
		String b = "acdb";
		String c = "acdv";
		if (isPermuation(a, b))
			System.out.println("a is b's  permutation");
		if (isPermuation(c, b))
			System.out.println("c is b's  permutation");

	}

	/*
	 * Again use a boolean array and the ASCII code to solve the problem
	 * 
	 */
	public static boolean isPermuation(String s1, String s2) {
		int[] a = new int[256];
		// First to check whether the length is the same
		if (s1.length() != s2.length())
			return false;
		// Count the number of each character if the first string
		for (int i = 0; i < s1.length(); i++) {
			a[s1.charAt(i)]++;
		}
		// Compare the number of second string with first string
		for (int i = 0; i < s1.length(); i++) {
			a[s2.charAt(i)]--;
			if (a[s2.charAt(i)] < 0)
				return false;
		}
		return true;
	}

}
