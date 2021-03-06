package ch4;

import java.util.Random;

public class Solution11 {
	class TreeNode{
		private int data;
		private TreeNode left;
		private TreeNode right;
		private int size=0;
		
		public TreeNode(int d){
			data=d;
			size++;
		}
		
		public TreeNode getRandomNode(){
			int leftSize=left==null?0:left.size();
			Random random=new Random();
			int index= random.nextInt(size);
			if(index<leftSize){
				return left.getRandomNode();
			}else if(index==leftSize){
				return this;
			}else{
				return right.getRandomNode();
			}
		}
		
		public int size(){
			return size;
		}
		
		public int data(){
			return data;
		}
		
		public void insert(int d){
			if(d<=data){
				if(left==null){
					left= new TreeNode(d);
				}else{
					left.insert(d);
				}
			}else{
				if(right==null){
					right=new TreeNode(d);
				}else{
					right.insert(d);
				}
			}
			size++;
		}
		
		public TreeNode find(int d){
			if(d==data){
				return this;
			}
			else if(d<=data){
				return left!=null?left.find(d):null;
			}
			else if(d>data){
				return right!=null?right.find(d):null;
			}
			return null;
		}
	}
}
