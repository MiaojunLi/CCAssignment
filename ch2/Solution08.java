package chapter2;


public class Solution08 {
	public static Node loopDetection(Node list){
		Node fast=list;
		Node slow=list;
		while(fast!=null || slow!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast)
				break;
		}
		if(fast==null || fast.next==null)
			return null;
		
		slow=list;
		while(fast.data!=slow.data){
			slow=slow.next;
			fast=fast.next;
		}
		return slow;

	}	
}
