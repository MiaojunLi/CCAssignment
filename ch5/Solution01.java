package ch5;
/*
 * The solution pf this problem will be first clear the bit from i to j of n, then move m 
 * to correct podition, snd finally use "or" operation on these two variables.   
 */
public class Solution01 {
	public static void main(String [] args){
		int n=112;
		int m=5;
		int i=1;
		int j=3;
		int b=insertion(m,n,i,j);
		System.out.println(b);
		
	}
	
	public static int insertion(int m, int n, int i, int j){
		n=clearBit(i,j,n);
		m=m<<i;
		return n|m;
	}
	/*there are many ways to clear the bits, here I use an interation to clear up one bit each time;*/
	public static int clearBit(int i,int j,int n){
		for(int k=i;k<=j;k++){
			int mask=~(1<<k);
			n=n&mask;
		}
		return n;
	}
	
	public static int clearBit2(int i, int j,int n){
		int num=(int) (Math.pow(2, j-i+1)-1);
		num<<=i;
		return n&(~num);
	}
}
