// package Java_DSA_Journey.Day6;

public class RowSum {
    public static void main(String[] args) {
        int[][] matrix = {
            {1,5,9},
            {5,116,33},
            {10,0,11}
        };
    
        // traversing through each element
        for(int[] row : matrix) {
            int sum = 0;
            for(int ele : row) {
                sum += ele;
            }
            System.out.println(sum);
        }
    }

}
