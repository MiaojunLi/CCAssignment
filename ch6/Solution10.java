package ch6;

import java.util.ArrayList;
/*
 * A Naive answer to this problem will be 28 days, but the optimal solution can be 7 days.
 * The below codes implement this algorithm.
 */
public class Solution10 {
	static int findPoisonBottle(ArrayList<Bottle> bottles, ArrayList<TestStrip> testStrips){
		return getResult(dropToStrips(bottles, testStrips));
	}

	void runTests(ArrayList<Bottle> bottles, ArrayList<TestStrip> testStrips){
		for (Bottle bottle : bottles){
			int id = getId();
			int bitIndex = 0;
			while (id > 0){
				if((id & 1) == 1){
					testStrips.get(bitIndex).drop(bottle); 
				}
				bitIndex += 1;
				id >>=1;
			}
		}

	}

	
	int getResult(ArrayList<TestStip> testStrips){
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for (TestStip testStrip : testStrips){
			int id = testStrip.getId(); 
			if (testStrip.isPositive())    
				result.add(id);
		}

		int posBits = 0;
		for (Integer bitPosition : result){
			posBits += 1 << bitPosition;       
		}	
		return posBits;
	}
}
