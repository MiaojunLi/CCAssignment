package ch4;

import java.util.ArrayList;
import java.util.LinkedList;
public class Solution09 {
	ArrayList<LinkedList<Integer>> allSequences(TreeNode node){
	ArrayList<LinkedList<Integer>> result=new ArrayList<LinkedList<Integer>>();
	if(node==null){
		result.add(new LinkedList<Integer>());
		return result;
	}
	
	LinkedList<Integer> prefix=new LinkedList<Integer>();
	prefix.add(node.data);
	/*
	 * Recurse on left and right right subtree
	 */
	ArrayList<LinkedList<Integer>> leftSequence=allSequences(node.left);
	ArrayList<LinkedList<Integer>> rightSequence=allSequences(node.right);
	
	for(LinkedList<Integer> left:leftSequence){
		for(LinkedList<Integer> right:rightSequence){
			ArrayList<LinkedList<Integer>> weaved=new ArrayList<LinkedList<Integer>> ();
			weaveList(left,right,weaved,prefix);
			result.addAll(weaved);
		}
	}
	return result;
	}

	
	void weaveList(LinkedList<Integer> first,LinkedList<Integer> second, ArrayList<LinkedList<Integer>> results,LinkedList<Integer> prefix){
		if(first.size()==0 || second.size()==0){
			LinkedList<Integer> result =(LinkedList<Integer>) prefix.clone();
			result.addAll(first);
			result.addAll(second);
			results.add(result);
			return;
		}
		int headfirst=first.removeFirst();
		prefix.add(headfirst);
		weaveList(first,second,results,prefix);
		prefix.removeLast();
		first.addFirst(headfirst);
		
		int headsecond=second.removeFirst();
		prefix.addLast(headsecond);
		weaveList(first,second,results,prefix);
		prefix.removeLast();
		second.addLast(headsecond);
	}
	
	
	
	
}
