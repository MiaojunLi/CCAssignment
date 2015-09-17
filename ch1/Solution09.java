/*
 * Solution to Chapter1 Problem 1.9
 */

public class Solution09 {
	public boolean isRotate(String s1, String s2) {
		if (s1.length() == s2.length() && s1.length() != 0) {
			String newstr = s1 + s2;
			if (isSubstring(newstr, s2))
				return true;
		}
		return false;
	}
}
