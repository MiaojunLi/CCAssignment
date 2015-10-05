package ch3;
/*
 * For this problem, we should just use another stack to keep track of the minimun elements
 * everytime there is a "pop" or "push" happening in the stack.
 */

import java.util.Stack;

class StackMin extends Stack<Integer>{
	private Stack<Integer> stack2;  //used to store the minimum elements
	
	public StackMin(){
		stack2=new Stack<Integer>();
	}
	
	public void push(int val){
		if(val<=min()){
			stack2.push(val);
		}
		super.push(val);
	}
	
	public Integer pop(){
		int val=super.pop();
		if(val==min()){
			stack2.pop();
		}
		return val;
	}
	public int min(){
		if(stack2.isEmpty())
			return Integer.MAX_VALUE;
		else return stack2.peek();
	}
}
public class Solution02 {
	
	
	
}
