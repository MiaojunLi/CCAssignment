package ch4;

public class Solution04 {
	/*
	 * A simple recursiev slotion,but it is not very efficient.
	 * Because at each node, we should recurse through its entire subtree,
	 * which reslut in some useless call to getHeight();
	 * O(nlogn) time
	 */
	public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(Math.abs(getHeight(root.left)-getHeight(root.right))>1) return false;
        if(isBalanced(root.left)==false) return false;
        if(isBalanced(root.right)==false) return false;
        return true;
    }

    public int getHeight(TreeNode root){
        int deep =0;
        if(root==null) return 0;
        else deep =1;
        int dl =getHeight(root.left);
        int dr =getHeight(root.right);
        deep+= dl>dr? dl:dr;
        return deep;
    }
    
    /*
     * An improved solution based on the first soluion.It will return -1 immediately when it
     * encounts an unbalanced height of a subtree, which can be more efficient.
     * O(n) time  
     */
	public boolean isBalanced2(TreeNode root) {
        if(helper(root)==-1) return false;
        else return true;
    }
    private int helper(TreeNode root){
        if(root==null) return 0;
        int leftH=helper(root.left);
        if(leftH==-1 ) return -1;
        int rightH=helper(root.right);
        if( rightH ==-1) return -1;

        if(Math.abs(leftH-rightH)>1) return -1;

        return 1+Math.max(leftH,rightH);

    }
	
}
