/*
 * Solution to Chapter1 Problem1.5
 */
public class Solution05 {
	public static void main(String[] args){
		String a1="pale";
		String a2="ple";
		String b1="pales";
		String b2="pale";
		String c1="pale";
		String c2="bale";
		String d1="pale";
		String d2="bake";
		if(isEdit(a1,a2)) System.out.println("true1");
		if(isEdit(b1,b2)) System.out.println("true2");
		if(isEdit(c1,c2)) System.out.println("true3");
		if(isEdit(d1,d2)) System.out.println("true4");
	}

	static boolean isEdit(String s1,String s2){
		if(s1.length()==s2.length() || Math.abs(s1.length()-s2.length())==1){  //First, check the difference of length
			return isAddOrRmOrReplace(s1,s2);	
		}
		return false;
		}
	
	
	static boolean isAddOrRmOrReplace(String s1,String s2) {
		boolean[] boo=new boolean[256];
		int same=0;// check the same character
		for(int i=0;i<s2.length();i++){
			boo[s2.charAt(i)]=true;
		}
		for(int i=0;i<s1.length();i++){
			if(boo[s1.charAt(i)]==true){
				same++;
			}
		}
		//if add or remove, same number is equal to the length of the short string
		if(s1.length()!=s2.length() && same==Math.min(s1.length(), s2.length())) return true;
		//if replace, same number is equal to length-1;
		if(s1.length()==s2.length() && same==s1.length()-1) return true;
		return false;
	}
}
