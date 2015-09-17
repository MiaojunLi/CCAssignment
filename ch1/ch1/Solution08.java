/*
 * Solution to Chapter1 Problem1.8
 */
public class Solution08 {
	public static void main(String [] args){
		int[][]a={{1,2,3,4},{2,3,1,4},{2,3,4,0}};
		setZeros(a);
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[0].length;j++){
				
					System.out.print(a[i][j]+" ");
				
			}
		}
	}
	
	public static void setZeros(int[][] matrix){
	int row=0;
	int col=0;
	for(int i=0;i<matrix.length;i++){
		for(int j=0;j<matrix[0].length;j++){
			if(matrix[i][j]==0){
				row=row|(1<<i);
				System.out.println(row);
				col=col|(1<<j);
				System.out.println(col);

			}
		}
	}
	for(int i=0;i<matrix.length;i++){
		if((row & (1<<i))>=1) nullifyRow(matrix,i);
	}
	for(int j=0;j<matrix[0].length;j++){
		if((col & (1<<j))>=1) nullifyCol(matrix,j);
	}
	}
	
	static void nullifyRow(int[][]matrix,int row){
		for(int i=0;i<matrix[0].length;i++){
			matrix[row][i]=0;
		}
	}
	static void nullifyCol(int[][]matrix,int col){
		for(int i=0;i<matrix.length;i++){
			matrix[i][col]=0;
		}
	}
}
