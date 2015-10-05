package ch3;

import java.util.ArrayList;
import java.util.Stack;

public class Solution03 {
	class MyStack extends Stack{
		private int capacity;
		
		public MyStack(int size){
			this.capacity=size;
		}
		public boolean isFull(){
			if(this.size()>capacity)
				return true;
			return false;
		}
		
	}
	class SetOfStacks{
		private ArrayList<MyStack> stacks=new ArrayList<MyStack>();
		private int capacity;
		int stackNum=0;
		public void push(int val){
			MyStack last=getLastStack();
			if(last!=null &&!last.isFull()){
				last.push(val);
			}
			else{
				MyStack stack=new MyStack(capacity);
				stack.push(val);
				stacks.add(stack);
				stackNum++;
			}
		}
		
		public int pop() throws EmptyStackException{
			MyStack last=getLastStack();
			if(last==null) throw new EmptyStackException();
			int val=(int) last.pop();
			if(last.isEmpty()) stacks.remove(stacks.size()-1);
			return val;
		}
		
		public MyStack getLastStack(){
			return stacks.get(stackNum);
		}
		
		//Follow up:Implement a function popAt(int index) which performs a pop operation on a 
		//specific substack
		
		/*
		 * I assume that we allow some of stacks can be not at full capacity. 
		 */
		public int popAt(int index){
			if(stacks.get(index)==null)
				return -1;				//-1 means error;
			else{
				if(!stacks.get(index).isEmpty()){
					return  (int) stacks.get(index).pop();
				}
			}
				return -1;   
		}
	}
	
	
	
	
}
