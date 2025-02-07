/*
    Original Matrix (A):

      |  1   2   3  |
      |  4   5   6  |(m x n)

Transpose of Matrix (A^T):

    |  1   4  |
    |  2   5  |
    |  3   6  |(n x m)

 */

public class FindingTranspose {
    public static void main(String[] args) {
        int m=2,n=3; // rows and column
        //(m x n) matrix
        int [][] matrix = {
            {1,2,3},
            {4,5,6}
        };
        // printint transpose
        for(int col = 0;col < n;col++) {
            for(int row = 0;row<m;row++) {
                System.out.print(matrix[row][col]+" ");
            }
            System.out.println();
        }

        // storing transpose in another matrix(n x m)
        int[][] trans = new int [n][m];
        for(int row = 0;row < n;row++) {
            for(int col = 0;col<m;col++) {
                trans[row][col] = matrix[col][row];
            }
        }
        // printing the transpose
        for(int[] row :trans) {
            for(int ele: row) {
                System.out.print(ele+" ");
            }
            System.out.println();
        }
    }
}