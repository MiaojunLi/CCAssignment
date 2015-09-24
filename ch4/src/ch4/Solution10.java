package ch4;

public class Solution10 {
	boolean containsTree(TreeNode n1,TreeNode n2){
		if(n2==null) return true;
		return subTree(n1,n2);
	}
	
	boolean subTree(TreeNode n1,TreeNode n2){
		if(n1==null) return false;
		else if(n1.data==n2.data && matchTree(n1,n2)){
			return true;
		}
		return (subTree(n1.left,n2)|| subTree(n1.right,n2));
	}
	
	boolean matchTree(TreeNode p1,TreeNode p2){
		if(p1==null && p2==null) return true;
		else if(p1==null || p2==null)
			return false;
		else if(p1.data!=p2.data)
			return false;
		return (matchTree(p1.left,p2.left) && matchTree(p1.right,p2.right)); 
	}
}
