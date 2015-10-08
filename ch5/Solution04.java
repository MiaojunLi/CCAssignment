package ch5;

public class Solution04 {
	public static void main(String[] args){
		int num=12;
		int num2=155;
		System.out.println(getNextSmaller(num));
		System.out.println(getNextBigger(num2));
	}
	static int getNextSmaller(int n){
		int tmp=n;
		int c0=0;
		int c1=0;
		while((tmp&1)==1){
			c1++;
			tmp>>=1;
		}
		if(tmp==0)
			return -1;
		while((tmp&1)==0&(tmp!=0)){
			c0++;
			tmp>>=1;
		}
		
		int p=c0+c1;
		
		n&=((~0)<<(p+1));	//clear from bit p onwards
		int mask=(1<<(c1+1))-1;  //Sequence of (c1+1) ones 
		mask=mask<<(c0-1);	
		return n|mask;
	}
	
	static int getNextBigger(int n){
		int c=n;
		int c0=0;
		int c1=0;
		while((c&1)==0 & (c!=0)){
			c0++;
			c>>=1;
		}
		while((c&1)==1){
			c1++;
			c>>=1;
		}
		if(c0+c1==31 || c0+c1 ==0){
			return -1;
		}
		
		int p=c0+c1;
		n=n|(1<<p);			//flip rightmost non-trailing zero
		n&=~((1<<p)-1);		//clear all bits on the right of p
		n|=(1<<(c1-1))-1;   //Insert (c1-1) ones on the right 
		return n;		
	}
}
