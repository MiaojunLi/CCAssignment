package ch10;

public class Solution08 {
	public static void main(String [] args){
		int a[]={1,2,3,4,5,6,7,8,4,8};
		checkDuplicates(a);
	}
	static void checkDuplicates(int [] array){
		Bitset bs=new Bitset(3200);
		for(int i=0;i<array.length;i++){
			int num=array[i]-1; //bitset starts from 0, number starts from 1
			if(bs.get(num)){
				System.out.println(array[i]);
			}else{
				bs.set(num);
			}
		}
	}
	
	
}
class Bitset{
	int[] bitset;
	public Bitset(int size){
		bitset=new int[(size>>5)+1];
	}
	
	public boolean get(int a){
		int num=a>>5;
		int bitnum=a&(0x1F);
		return (bitset[num] & (1<<bitnum)) !=0;
	}
	public void set(int a){
		int num=a>>5;
		int bitnum=a&(0x1F);
		bitset[num]|=(1<<bitnum);
	}
}