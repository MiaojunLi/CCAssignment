package ch6;
/*
 * I show a brute force solution here. 
 * But as we think deeply, we can see that, for example number 15, door 15 is toggled on round 
 * 1,3,5 and 15, which are factors of 15. And it indicates that a door is open only the number of factors
 * for a door is odd. And most of the number have even factors, because factors are often in pairs.For example,
 * 12, the factors are(1,12),(2,6),(3,4). And the special cases are something like 25, factors are(1,25),(5,5), 
 * which factors are odd. So we know the answer is n*n in 1~100.
 */
public class Solution09 {
	
	public static void setlock(boolean []a ){
		for(int i=0;i<a.length;i++){
			a[i]=true;
		}
		for(int i=1;i<100;i++){
			for(int j=i;j<100;j=j+i+1){
				if(a[j]==true) 
					a[j]=false;
				else
					a[j]=true;
				
			}
		}
		for(int i=0;i<a.length;i++){
			if(a[i]==true)
				System.out.println(i+1);
		}
	}
	
}
