package ch4;

public class Solution04 {
	int checkHeight(TreeNode root){
	if(root==null) return 0;
	int leftHeight=checkHeight(root.left);
	if(leftHeight==-1){
		return -1;
	}
	
	int rightHeight=checkHeight(root.right);
	if(rightHeight==-1){
		return -1;
	}
	int heightDif=leftHeight-rightHeight;
	if(Math.abs(heightDif)==-1){
		return -1;
	}else{
		return Math.max(leftHeight, rightHeight)+1;
	}
	}
	
	boolean isBalance(TreeNode root){
		if(checkHeight(root)==-1){
			return false;
		}else{
			return true;
		}
	}
}
