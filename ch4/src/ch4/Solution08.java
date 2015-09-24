package ch4;

public class Solution08 {
	/*
	 * Solution1: Based on the assumption "with links to the parent"
	 * It is a very simple method,which is just to check whether p's 
	 * ancestor is on the same path when q moving upward. 
	 */
	TreeNode commonAncestor(TreeNode p,TreeNode q){
		if(p==q) return null;
		TreeNode ancestor =p;
		while(ancestor!=null){
			if(isSamePath(ancestor,q))
				return ancestor;
			ancestor=ancestor.parent;
		}
		return null;
	}
	
	boolean isSamePath(TreeNode p,TreeNode q){
		while(q!=null){
			if(p==q)
				return true;
			q=q.parent;
		}
		return false;
	}
	/*
	 * Solution: Based on "without links to parents".
	 * This solution recursivly check whether q and p are on the same side,
	 * when arriving the point where they are not on the same side, it's their ancestor
	 */
	TreeNode commonAncestor2(TreeNode root, TreeNode p,TreeNode q){
		if(!cover(root,p)|| !cover(root,q))
			return null;
		return acnestorSolver(root,p,q);
	}
	boolean cover(TreeNode root,TreeNode n){
		if(root==null) return false;
		if(root==n) return false;
		return cover(root.left,n) || cover(root.right,n);
	}
	
	TreeNode acnestorSolver(TreeNode root,TreeNode p,TreeNode q){
		if(root==null)
			return null;
		else if(root==p)
			return p;
		else if(root==q)
			return q;
		boolean pisOnleft=cover(root.left,p);
		boolean qisOnleft=cover(root.left,q);
		if(qisOnleft!=qisOnleft) return root;
		TreeNode child=pisOnleft? root.left:root.right;
		return acnestorSolver(child,p,q);
	}
}
