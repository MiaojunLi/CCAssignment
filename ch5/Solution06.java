package ch5;
/*
 * The most straightforward solution will be count how many bits in these two numbers are differnt,
 * and we can do it with 'XOR' operation. But a trick here is that we use C&(c-1) operation rather than 
 * counting every bit to get the number of different bits in A^B. It will be faster.
 */
public class Solution06 {
	public static void main(String[] args){
		int a=12;
		int b=24;
		System.out.println(bitSwapRequired(a, b));
	}
	
	public static int bitSwapRequired(int a, int b){
		int count=0;
		int c=a^b;
		while(c!=0){
			c=c&(c-1); //c&(c-1) will clear the least significant bit in c
			count++;
		}
		return count;
	}
}
