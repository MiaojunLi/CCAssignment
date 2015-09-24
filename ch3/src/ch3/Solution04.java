package ch3;

import java.util.Stack;

public class Solution04 {
	class MyQueue<T>{
		Stack<T> stack1,stack2;
		public MyQueue(){
			stack1=new Stack<T>();
			stack2=new Stack<T>();
		}
		public void add(T val){
			stack1.push(val);
		}
		public T peek(){
			shiftStacks();
			return stack2.peek();
		}
		
		public T remove(){
			shiftStacks();
			return stack2.pop();
		}
		
		public void shiftStacks(){
			if(stack2.isEmpty()){
				while(!stack1.isEmpty()){
					stack2.push(stack1.peek());
				}
			}
		}
	}
}
