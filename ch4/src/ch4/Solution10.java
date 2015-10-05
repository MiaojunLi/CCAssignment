package ch4;

public class Solution10 {
	boolean containsTree(TreeNode n1,TreeNode n2){
		if(n2==null) return true;
		return isSubTree(n1,n2);
	}
	
	boolean isSubTree(TreeNode n1,TreeNode n2){
		if(n1==null) return false;
		else if(n1.data==n2.data && isSameTree(n1,n2)){
			return true;
		}
		return (isSubTree(n1.left,n2)|| isSubTree(n1.right,n2));
	}
	
	boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p!=null && q!=null && q.data==p.data && isSameTree(p.left,q.left)&&isSameTree(p.right,q.right)) return true;
        else return false;
    }
}
