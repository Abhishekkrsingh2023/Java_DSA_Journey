// Rotate a matrix by 90'
public class RotateMatrix {
    // helper function
    public static void getReversed(int[] arr) {
        int i=0,j=arr.length-1;
        while(i<j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    public static void main(String[] args) {
        int[][] matrix ={
            {1,2,3,10},
            {4,5,6,7},
            {7,8,9,10}
        };

        int[][] transpose = new int[matrix[0].length][matrix.length];

        // transposing the matrix
        for(int row = 0;row < transpose.length;row++) {
            for(int col = 0;col<transpose[0].length;col++) {
                transpose[row][col] = matrix[col][row];
            }
        }
        
        for(int row = 0;row<transpose.length;row++) {
            getReversed(transpose[row]); // reversing each row
        }

        // printing the rotated matrix
        for(int[] row:transpose) {
            for(int ele:row) {
                System.out.print(ele +" ");
            }
            System.out.println();
        }

    }
}
