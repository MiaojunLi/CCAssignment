package ch4;

import javax.swing.tree.TreeNode;

public class Solution02 {
	/*
	 * First,insert the middle element of the array into the tree;
	 * Then,insert the left subarray lelments and insert the right subarray elements
	 * Then,recurse
	 */
	TreeNode creatMinialBST(int a[]){
		if(a.length==0) return null;
		TreeNode n=buildBST(a,0,a.length-1);
		return n;
	}
	
	TreeNode buildBST(int[]a,int start,int end){
		if(start>end) return null;
		int mid=start+(end-start)/2;
		TreeNode n=new TreeNode(a[mid]);
		n.left=buildBST(a,start,mid-1);
		n.right=buildBST(a,mid+1,end);
		return n;
	}
}
