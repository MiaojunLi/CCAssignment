package chapter2;


class ListInfo{
	public Node n;
	public int size;
	public ListInfo(Node n, int size){
		this.n=n;
		this.size=size;
	}
}
public class Solution07 {
	
	
	public static Node findInterSection(Node list1,Node list2){
		ListInfo info1=getTailAndSize(list1);
		ListInfo info2=getTailAndSize(list2);
		
		if(info1.n!=info2.n) return null;
		
		Node shorter=info1.size<info2.size? list1:list2;
		Node longer=info1.size<info2.size? list2:list1;

		longer=returnKthNode(longer,Math.abs(info1.size-info2.size));
		
		System.out.println("longer "+getTailAndSize(longer).size);
		System.out.println("shorter "+getTailAndSize(shorter).size);

		while(shorter!=longer){
			shorter=shorter.next;
			longer=longer.next;
		}
		
		return shorter;
	}
	
	public static ListInfo getTailAndSize(Node list){
		if(list==null) return null;
		int n=0;
		Node current= list;
		while(current!=null){
			n++;
			current=current.next;
		}
		return new ListInfo(current,n);
	}
	
	public static Node returnKthNode(Node list,int k){
		if(k<1 || list==null) return list;
		Node current=list;
		while(k>0 && current!=null){
			current=current.next;
			k--;
		}
		return current;
	}
}
