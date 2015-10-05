package ch4;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;
import javax.xml.soap.Node;

public class Solution03 {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val){
			this.val=val;
		}
		
	}
	/*
	 * This solution uses a modification of pre-order  traversal algorithm adn pass the 
	 * next level to the next recursive call
	 */
	void createLevelLickedList(TreeNode root,ArrayList<LinkedList<TreeNode>> lists,int level){
		if(root==null) return;
		LinkedList<TreeNode> list=null;
		if(lists.size()==level){
			list=new LinkedList<TreeNode>();
		}
		else 
			list=lists.get(level);
		list.add(root);
		createLevelLickedList(root.left, lists,level+1);
		createLevelLickedList(root.right, lists,level+1);
	}
	
	ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
		ArrayList<LinkedList<TreeNode>>lists=new ArrayList<LinkedList<TreeNode>>();
		createLevelLickedList(root,lists,0);
		return lists;
	}
	
	/*
	 * The second solution utilizes the features of the breadth-first search algorithm,
	 * which deal with the tree level by level.
	 */
	ArrayList<LinkedList<TreeNode>> createLevelLinkedList2(TreeNode root){
		ArrayList<LinkedList<TreeNode>> lists=new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> current=new LinkedList<TreeNode>();
		if(root!=null){
			current.add(root);
		}
		while(current.size()!=0){
			lists.add(current);
			LinkedList<TreeNode> parent=current;
			current=new LinkedList<TreeNode>();
			for(TreeNode n:parent){
				if(n.left!=null){
					current.add(n.left);
				}
				if(n.right!=null){
					current.add(n.right);
				}
			}
			
		}
		return lists;
	}
}
