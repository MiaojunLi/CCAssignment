package ch10;

public class Solution11 {
	void sortVallyPeak(int[] array){
		for(int i=1;i<array.length;i=i+2){
			int maxIdx=maxIndex(array,i-1,i,i+1);
		if(i!=maxIdx){
			int tmp=array[i];
			array[i]=array[maxIdx];
			array[maxIdx]=tmp;
		}
		}
	}
	
	int maxIndex(int[]array,int a,int b, int c){
		int len=array.length;
		//Should check if a,b,c are out of bound
		int valueA= (a>=0 && a<len)? array[a]: Integer.MIN_VALUE;
		int valueB= (a>=0 && a<len)? array[b]: Integer.MIN_VALUE;
		int valueC= (a>=0 && a<len)? array[c]: Integer.MIN_VALUE;
		
		int max=Math.max(valueC, Math.max(valueA, valueB));
		if(max==valueA) return a;
		if(max==valueB) return b;
		else return c;
	}
}
