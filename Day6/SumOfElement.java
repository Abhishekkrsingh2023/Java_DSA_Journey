// package Java_DSA_Journey.Day6;

public class SumOfElement {
    public static void main(String[] args) {
        int[][] matrix = {
            {1,5,9},
            {5,116,33},
            {10,0,11}
        };

        int sum = 0;
        // traversing through each element
        for(int[] row : matrix)
            for(int ele : row)
                sum += ele;
        // Printing the sum
        System.out.println(sum);
    }
}
