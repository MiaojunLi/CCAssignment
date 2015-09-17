/*
 * Solution to Chapter1 Problem 1.7
 * This method performs circular rotation of each layer, and it costs O(n*n) time,
 * which is the best we can do.
 */
public class Solution07 {

	public static void matrixRotate(int[][] matrix, int n) {
		for (int i = 0; i < n / 2; i++) { // interate through each layer of the  matrix
											
			int first = i; // the frst element of each layer
			int last = n - 1 - i; // the last element of each layer
			for (int j = first; j < last; j++) {
				int offset = i - first;
				int top = matrix[first][i]; // save top layer

				matrix[first][i] = matrix[last - offset][first]; // left->top;

				matrix[last - offset][first] = matrix[last][last - offset]; // bottom->left;

				matrix[last][last - offset] = matrix[i][last]; // right->bottom;

				matrix[i][last] = top; // top->rught;

			}
		}
	}
}
