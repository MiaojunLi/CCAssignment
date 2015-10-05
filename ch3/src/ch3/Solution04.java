package ch3;

import java.util.Stack;

public class Solution04 {
	class MyQueue<T> {
		Stack<T> stack1, stack2;

		public MyQueue() {
			stack1 = new Stack<T>(); // store the new elements
			stack2 = new Stack<T>(); // store the old elements
		}

		public void add(T val) {
			stack1.push(val);
		}

		public T peek() {
			if (stack2.isEmpty()) {
				shiftStacks();
			}
			return stack2.peek();
		}

		public T remove() {
			if (stack2.isEmpty()) {
				shiftStacks();
			}
			return stack2.pop();
		}

		public void shiftStacks() { // shift elements from stack1 tp stack2
			while (!stack1.isEmpty()) {
				stack2.push(stack1.peek());
			}
		}
	}
}
