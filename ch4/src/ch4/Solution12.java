package ch4;

import java.util.HashMap;

public class Solution12 {
	int pathSum(TreeNode root,int target){
		if(root==null) return 0;
		HashMap<Integer,Integer> pathCount =new HashMap<Integer,Integer>();
		incrementhashTable(pathCount,0,1);
		return  pathSum(root,target,0,pathCount);
		}
	int pathSum(TreeNode node,int target,int runningSum,HashMap<Integer,Integer>pathCount){
		if(node==null) return 0;
		runningSum+=node.data;
		incrementhashTable(pathCount,runningSum,1);//Aa running sum
		
		//count paths with sum ending at current node
		int sum=runningSum-target;
		int totalPaths=pathCount.containsKey(sum)? pathCount.get(sum):0;
		
		//count path with sum on the left and right
		totalPaths+=pathSum(node.left,target,runningSum,pathCount);
		totalPaths+=pathSum(node.right,target,runningSum,pathCount);
		
		incrementhashTable(pathCount,runningSum,-1);//remove runningSum
		return totalPaths;
	}
	
	void incrementhashTable(HashMap<Integer,Integer> hashTable,int key, int delta){
		if(!hashTable.containsKey(key)){
			hashTable.put(key, 0);
		}
		hashTable.put(key, hashTable.get(key)+delta);
	}

}
