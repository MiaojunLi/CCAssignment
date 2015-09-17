package chapter2;
import java.util.HashSet;

/*
 * Solution to Chapter1 Problem2.1
 */

class Node{
	Node next=null;
	int data;
	public Node(int d){
		data=d;
	}
	public void appendToend(int d){
			 Node end=new Node(d);
			 Node n=this;
			 while(n.next!=null){
				 n=n.next;
			 }
			 n.next=end;
	}
	public void nodePrint(){
		System.out.println(this.data);
	}
}

public class Solution01 {
	
	/*
	 * This solution uses a hashset, and it takes only O(n) time 
	 */
	public static void rmDuplicate(Node head){
		HashSet<Integer> set=new HashSet<Integer>();
		Node previous =null;
		while(head!=null){
			if(set.contains(head.data)){
				previous.next=head.next;
			}
			else{
				set.add(head.data);
				previous=head;
			}
			head=head.next;
		}
	}
	
	
	
	
	/*
	 * Follow up:
	 * This solution doesn't use temporary buffer, but it takes O(n*n) time 
	 */
	public static void rmDuplicate2(Node head){        
		Node first=head;
		/*Remove the future nodes that have the same value*/
		while(first!=null){
			Node second=first;
			while(second.next!=null){
				if(second.next.data==first.data)
				second.next=second.next.next;
				else second=second.next;
			}
			first=first.next;
		}
	}

	
}
