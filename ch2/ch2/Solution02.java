package chapter2;

class Index{
	int val=0;
}
public class Solution02 {
	
	public Node returnKTolast(Node head,int k){
		Index index=new Index();
		index.val=0;
		return returnKTolast(head,k,index);
	}
	
	public Node returnKTolast(Node head,int k,Index index){
		if(head==null) return null;
		Node current=returnKTolast(head.next, k,index);
		index.val+=1;
		if(k==index.val) return head;
		return current;
	}
}
