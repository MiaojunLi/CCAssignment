package ch4;

public class Solution06 {
	class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode parent;
	}
	
	TreeNode inorderSuccessor(TreeNode root){
		if(root==null) return null;
		
		if(root.right!=null){
			return leftMostChild(root.right);
		}else{
			TreeNode cur=root;
			TreeNode parent=cur.parent;
			while(parent!=null && parent.left!=cur){
				cur=parent;
				parent=parent.parent;
			}
			return parent;
		}
	}
	
	TreeNode leftMostChild(TreeNode root){
		if(root==null){
			return null;
		}
		while(root.left!=null){
			root=root.left;
		}
		return root;
	}
}
