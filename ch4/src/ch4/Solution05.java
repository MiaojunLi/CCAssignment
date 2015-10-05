package ch4;

import java.util.Stack;

class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
}
public class Solution05 {
	/*
	 * Solution 1: Inorder traversal, uses a stack to track the previous number,
	 * which can be used to compared with the current one
	 */
	public boolean isValidBST(TreeNode root) {
	    Stack<Integer> prev = new Stack<>();
	    return inorder(root, prev);
	}

	private boolean inorder(TreeNode node, Stack<Integer> prev) {
	    if (node == null) return true;
	    if (!inorder(node.left, prev)) return false;
	    if (!prev.isEmpty() && prev.pop() >= node.data) return false;
	    prev.push(node.data);
	    return inorder(node.right, prev);
	}
	
	/*
	 * Solution2:Min,Max 
	 */
	
	boolean checkBST2(TreeNode root){
		return checkBST2(root,null,null);
	}
	boolean checkBST2(TreeNode root,Integer min,Integer max){
		if(root==null) return true;
		if((min!=null&& root.data<=min)||(max!=null && root.data>=max)){
			return false;
		}
		if(!checkBST2(root.left, min, root.data)|| !checkBST2(root.right, root.data, max)){
			return false;
		}
		return true;
	}
}
