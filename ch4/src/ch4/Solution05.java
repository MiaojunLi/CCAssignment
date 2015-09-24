package ch4;
class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
}
public class Solution05 {
	boolean checkBST(TreeNode root){
		return checkBST(root,null,null);
	}
	boolean checkBST(TreeNode root,Integer min,Integer max){
		if(root==null) return true;
		if((min!=null&& root.data<=min)||(max!=null && root.data>max)){
			return false;
		}
		if(!checkBST(root.left, min, root.data)|| !checkBST(root.right, root.data, max)){
			return false;
		}
		return true;
	}
}
