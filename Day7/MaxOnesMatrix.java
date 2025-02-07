public class MaxOnesMatrix {
    /*
     Matrix (A):
    |  0   1   0   1   0  |
    |  1   0   1   0   1  | --> row with max 1
    |  0   1   1   0   1  |
     */
    public static void main(String[] args) {
        int[][] matrix = {
            {0, 1, 0, 1, 0},
            {1, 0, 1, 0, 1},
            {0, 1, 1, 0, 1}
        };

        // Method 1;(Counting the 1's)
        int idx=-1,maxOne = 0;
        for(int i = 0;i<matrix.length;i++) {
            int count = 0;
            for(int j=0;j<matrix[0].length;j++) {
                if(matrix[i][j]==1) count++;
            }
            if(maxOne<count) {
                maxOne = count;
                idx = i;
            }
        }
        // Method 2 :(Using the sum approach)
        int maxSum = 0,idx2=-1;
        for(int i = 0;i<matrix.length;i++) {
            int sum = 0;
            for(int j=0;j<matrix[0].length;j++) {
                sum += matrix[i][j];
            }
            if(maxSum<sum) {
                maxSum = sum;
                idx2 = i;
            }
        }

        System.out.println("Row with index "+idx+" has maximum no. of 1's : "+maxOne);
        System.out.println("Row with index "+idx2+" has maximum no. of 1's : "+maxSum);
    }
}
