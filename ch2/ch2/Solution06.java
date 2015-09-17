package chapter2;

import java.util.Stack;

	
	/*
	 * Since we can reverse the list and compare it with the original list to check if it is palindrome
	 * This method first uses a stack to store the list data, then each time compares the stack.peek() value 
	 * with the current list value.
	 * A faster and more efficient method will be only storing and comparing the first half of the list data
	 * and comparing it with the second half of the list by using fast runner and slow runner. 
	 */
public class Solution06{
	public static boolean isPalindrome(Node head){
		Stack<Integer> stack=new Stack<Integer>();
		Node n=head;
		while(n!=null){
			stack.push(n.data);
			n=n.next;
		}
		n=head;
		while(n!=null){
			if(n.data==stack.peek())
				stack.pop();
			else{
				return false;
			}
			n=n.next;	
		}
		return true;
	}
}

