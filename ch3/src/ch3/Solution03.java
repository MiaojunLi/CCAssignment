package ch3;

import java.util.ArrayList;
import java.util.Stack;

public class Solution03 {
	class SetOfStacks{
		ArrayList<Stack> stacks=new ArrayList<Stack>();
		public void psuh(int val){
			Stack last=getLastStack();
			if(last!=null &&!last.isFull()){
				last.push(val);
			}
			else{
				Stack<Integer>stack=new Stack(capacity);
				stack.push(val);
				stacks.add(stack);
			}
		}
		
		public int pop(){
			Stack last=getLastStack();
			if(last==null) throw new EmptyStackException();
			int val=(int) last.pop();
			if(last.isEmpty()) stacks.remove(stacks.size()-1);
			return val;
		}
	}
}
