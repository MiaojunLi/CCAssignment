package ch5;

public class Solution03 {
	public static void main(String [] args){
		int a=1775;
		int len=longestSeqOf1s(a);
		System.out.println(len);
	}
	public static int longestSeqOf1s(int n){
		int searching=0;
		int[] sequences={0,0,0};
		int maxSeq=1;
		for(int i=0;i<32;i++){
			if((n&1)!=searching){
				if(searching==1){
					maxSeq=Math.max(maxSeq, getMaxSeq(sequences));
				}
				searching=n&1;
				shift(sequences);
			}
			sequences[0]++;
			n>>>=1;
		}
		if(searching==0){
			shift(sequences);
		}
		return Math.max(maxSeq, getMaxSeq(sequences));
	}
	
	static int getMaxSeq(int [] sequences){
		if(sequences[1]==1) {
			return sequences[0]+sequences[2]+1;
		}
		else if(sequences[1]==0){
			return Math.max(sequences[0], sequences[2]);
		}else{
			return Math.max(sequences[0], sequences[2])+1;
		}
	}
	
	static void shift(int [] sequences){
		sequences[2]=sequences[1];
		sequences[1]=sequences[0];
		sequences[0]=0;
	}
}
