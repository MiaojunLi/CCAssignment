package chapter2;

public class Solution04 {
	public Node partition(Node head, int x) {
        Node head1=null;
        Node tail1=null;
        Node head2=null;
        Node tail2=null;
        while(head!=null){
            Node next=head.next;
            head.next=null;
            //The elements less than x will be connected to the first list
            if(head.data<x){
                if(head1==null){
                    head1=head;
                    tail1=head;
                }
                else{
                    tail1.next=head;
                    tail1=head;
                }
            }
            //The elements greater than x will be connected to the second list
            else{
                if(head2==null){
                    head2=head;
                    tail2=head;
                }
                else{
                    tail2.next=head;
                    tail2=head;
                }
            }
            head=next;
            }
        if(head1==null) return head2;
        tail1.next=head2;     //combine the two lists
        return head1;
    }
}
