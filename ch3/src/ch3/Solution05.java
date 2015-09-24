package ch3;

import java.util.Stack;

public class Solution05 {
	
	public void main(String [] args){
		Stack<Integer> stk= new Stack<Integer>();
		stk.push(5);
		stk.push(3);
		stk.push(1);
		stk.push(7);
		stk.push(2);
		stk=sort(stk);
		while(!stk.isEmpty()){
			System.out.println(stk.pop());
		}

	}

	public Stack<Integer> sort(Stack<Integer> s1){
		Stack<Integer> s2=new Stack<Integer>();
		while(!s1.isEmpty()){
			if(s2.isEmpty() || s1.peek()>s2.peek()){
				s2.push(s1.pop());
			}
			else{
				int tmp=s1.pop();
				while(!s2.isEmpty()){
					if(s2.peek()<tmp){
						s1.push(s2.pop());
					}
				}
				s2.push(tmp);
			}
	}
		return s2;
	}
}
