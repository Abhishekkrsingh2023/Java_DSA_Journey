// applicable for square matrix (m x m)
public class TransposeSameMatrix {
    // swap function
    public static void swap(int[][] arr,int i,int j) {
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        // int[][] matrix2 = {
        //     {1,2},
        //     {4,5}
        // };
        int size = matrix.length;
        for(int i=0;i<size;i++) {
            for(int j=i;j<size;j++) { // traversing upper triangle only
                swap(matrix, i, j);
            }
        }
        for(int[] row :matrix) {
            for(int ele: row) {
                System.out.print(ele+" ");
            }
            System.out.println();
        }

    }
}
