package ch6;

import java.util.Random;
/*
 * We use G,BG,BBG,BBBG,... to denote all the possible sequences of children, where B means boy 
 * and G means girl. 
 * The logic of this problem is that p(G)=1/2; p(BG)=1/4; p(BBG)=1/8, and so on
 * so the gendor rate of the new generation is boys/girls=(0*p(G)+1*p(BG)+2*p(BBg)+...+n*p(BBB..G))/(n),
 * when n is large, the rate will close to 0.5;
 *
 */
public class Solution07 {
	public static void main(String [] args){
		int n=1000;
		ratio(n);
	}
	static void ratio(int n){
		int girls=0;
		int boys=0;
		Random random=new Random();
		for(int i=0;i<n;i++){
			if(!random.nextBoolean()){
				boys++;
				while(!random.nextBoolean()){
					boys++;
				}	
			}
			girls++;
		}
		System.out.println((double)girls/(boys+girls));
	}
}
