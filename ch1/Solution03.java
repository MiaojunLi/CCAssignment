/*
 * Solution to Chapter1 Problem1.3
 */
public class Solution03 {
	public static void main(String[] args) {
		char[] a = { 'c', ' ', 'd', 'd', ' ', 's', 'f' };
		char[] b = spacesReplace(a, 7);
		for (int i = 0; i < b.length; i++)
			System.out.print(b[i]);
	}
	/*
	 * This method first interates through the array,to count the number of the space
	 * Then it replace the space in the array in reverse order
	 */
	static char[] spacesReplace(char[] s, int length) {
		int spaces = 0;
		int newLength;
		for (int i = 0; i < length; i++) {
			if (s[i] == ' ')
				spaces++;
		}
		System.out.println(spaces);
		newLength = length + spaces * 2;
		char[] b = new char[newLength];
		for (int i = length - 1; i >= 0; i--) {
			if (s[i] == ' ') {
				b[newLength - 3] = '%';
				b[newLength - 2] = '2';
				b[newLength - 1] = '0';
				newLength = newLength - 3;
			} else {
				b[newLength - 1] = s[i];
				newLength = newLength - 1;
			}
		}
		return b;
	}
}
