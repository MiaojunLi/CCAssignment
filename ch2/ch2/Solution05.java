package chapter2;

import java.util.Stack;

class Node {
	Node next = null;
	int data;

	public Node(int d) {
		data = d;
	}

	public void appendToend(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	public void nodePrint() {
		System.out.println(this.data);
	}
}

public class Solution05 {
	public static void main(String[] args) {
		Node head1 = new Node(6);
		int[] data1 = { 7, 1, 7, 8 };
		for (int i = 0; i < data1.length; i++) {
			head1.appendToend(data1[i]);
		}
		Node head2 = new Node(3);
		for (int i = 0; i < data1.length; i++) {
			head2.appendToend(data1[i]);
		}

		Node head3 = listsum2(head1, head2);

		while (head3 != null) {
			head3.nodePrint();
			head3 = head3.next;
		}
	}

	/*
	 * The lists are stored in reserve order. This method starts from the head
	 * of the two lists and if the carry value is set, it can be added to the
	 * next list
	 */
	public static Node listSum(Node head1, Node head2) {
		if (head1 == null && head2 == null)
			return null;
		if (head1 == null || head2 == null)
			return head1 == null ? head2 : head1;
		Node n1 = head1;
		Node n2 = head2;
		Node head3 = new Node(0); // The new list of sum
		Node tail = head3;
		int carry = 0;
		while (n1 != null || n2 != null || carry != 0) {
			int s = (n1 != null ? n1.data : 0) + (n2 != null ? n2.data : 0) + carry;
			carry = s / 10;
			s = s % 10;
			tail.next = new Node(s);
			tail = tail.next;
			n1 = (n1 == null ? null : n1.next);
			n2 = (n2 == null ? null : n2.next);
		}
		return head3.next;
	}

	/*
	 * Follow up:The lists are stored in forward order Since it's of the
	 * opposite direction of above list sum we can just use stacks to implement
	 * the reverse list sum
	 */
	public static Node listsum2(Node head1, Node head2) {
		if (head1 == null && head2 == null)
			return null;
		if (head1 == null || head2 == null)
			return head1 == null ? head2 : head1;
		Node n1 = head1;
		Node n2 = head2;
		Node head3 = new Node(0); // The new list of sum
		Node tail = head3;
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		Stack<Integer> stack3 = new Stack<Integer>();

		while (n1 != null || n2 != null) {
			if (n1 != null)
				stack1.push(n1.data);
			if (n2 != null)
				stack2.push(n2.data);
			System.out.println(n1.data + "   " + n2.data);
			n1 = (n1 == null ? null : n1.next);
			n2 = (n2 == null ? null : n2.next);
		}
		int carry = 0;
		while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {

			int sum = (stack1.isEmpty() ? 0 : stack1.pop()) + (stack2.isEmpty() ? 0 : stack2.pop()) + carry;
			carry = sum / 10;
			sum = sum % 10;
			stack3.push(sum);
		}
		while (!stack3.isEmpty()) {
			tail.next = new Node(stack3.pop());
			tail = tail.next;
		}

		return head3.next;
	}

}
