/*
 * Solution to Chapter1 Problem1.6
 */
public class Solution06 {
	public static void main(String[] args){
		String s="aaabbbcdfff";
		String s2="aabcdd";
		s=compression(s);
		s2=compression(s2);
		for(int i=0;i<s.length();i++){
			System.out.print(s.charAt(i));
		}
		System.out.println();

		for(int i=0;i<s2.length();i++){
			System.out.print(s2.charAt(i));
		}
	}
	
	
	public static String compression( String s){
		s=s+" ";  //In order to check the final character 
		StringBuilder newstr=new StringBuilder();  //StringBuilder will be much faster than String,when extending the original string
		int count=1; //To count the consecutive character 
		for(int i=0;i<s.length()-1;i++){
			if(s.charAt(i)==s.charAt(i+1)){
				count++;
			}
			else{
				newstr.append(s.charAt(i));
				newstr.append(String.valueOf(count));
				count=1;
			}
		}
		return newstr.length()<s.length()?newstr.toString():s;
	}
}
