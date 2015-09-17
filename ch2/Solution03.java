package chapter2;

public class Solution03 {
	public boolean nodeDelete(Node n){
		if(n==null || n.next==null)
			return false;
		Node next=n.next;
		n.data=n.next.data;
		n.next=next.next;
		return true;
		
	}
}
