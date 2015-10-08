package ch5;
/*
 * The solution to this problem will be use a mask 101010... to mask all the odd bits,
 * 010101... to mask all the even bits, and finally merge thses two values
 */
public class Solution07 {
	public static void main(String[]args){
		System.out.println(pairWiseSwap(8));
	}
	
	public static int pairWiseSwap(int x){
		int evenBits=(x&(0xaaaaaaaa))>>>1; //evenBits will shift right and fill the sign bit with 0
		int oddBits=(x&(0x55555555))<<1;	//oddBits will shift left
		return evenBits|oddBits;
	}
}
