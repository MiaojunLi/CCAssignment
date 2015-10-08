package ch5;

public class Solution02 {
	public static void main(String [] args){
		double a=0.71;
		double b=0.125;
		double c=1.21;
		printBinary(a);
		printBinary(b);
		printBinary(c);
		
	}
	static void printBinary(double num) {
		if (num <= 0 || num >= 1) {
			System.out.println("Error");
			return;
		}
		StringBuilder string = new StringBuilder();
		string.append(".");
		while (num != 0) {
			num = 2 * num;
			if (string.length() >= 32) {
				System.out.println("Error");
				return;
			}
			if (num >= 1) {
				string.append("1");
				num = num - 1;
			} else {
				string.append("0");
		
			}
		}
		System.out.println(string.toString());
	}
}
