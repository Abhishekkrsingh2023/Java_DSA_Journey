public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {1,2,3,4},
            {4,5,6,7},
            {8,9,10,11}
        };
        int m = matrix.length,n= matrix[0].length;
        int left = 0,right =n-1 ,top = 0,bottom =m-1 ;

        while(top<=bottom && left<= right) {
            // left -> right
            for(int i=left;i<=right;i++) {
                System.out.print(matrix[top][i] + " ");
            }
            top++;

            // top -> bottom
            for(int i=top;i<=bottom;i++) {
                System.out.print(matrix[i][right]+" ");
            }
            right--;

            // right -> left
            if(top <= bottom) {
                for(int i=right;i>=left;i--) {
                    System.out.print(matrix[bottom][i]+" ");
                }
                bottom--;
            }

            // bottom -> top
            if(right >= left) {
                for(int i=bottom;i>=top;i--) {
                    System.out.print(matrix[i][left]+" ");
                }
                left++;
            }
        }
    }
}
