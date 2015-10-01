package ch10;
/*
 * In this problem, though it is a data structure of a matrix, we can still apply binaey search
 * as long as we can find out the conditions for moving direction,since there are still orders in 
 * rows and columns.But it won't be easy to implement it. After figuring out what happens when 
 * searching for the targets, we will have a simple solution. 
 */
public class Solution09 {
	boolean searchElement(int[][] matrix,int target){
		int row=0;
		int col=matrix[0].length-1;
		while(row<matrix.length && col>=0){
			if(matrix[row][col]==target){
				return true;
			}
			else if(matrix[row][col]>target){
				col--;
			}
			else{
				row++;
			}
		}
		return false;
	}
}
