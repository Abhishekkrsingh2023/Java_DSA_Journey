// package Java_DSA_Journey.Day6;

public class MaxElement {
    public static void main(String[] args) {
        int[][] matrix = {
            {1,5,9},
            {5,116,33},
            {10,0,11}
        };

        int max = Integer.MIN_VALUE;

        for(int[] row : matrix)
            for(int ele : row)
                if(ele>max)
                    max = ele;
        // Displaying max element 
        System.out.println(max);
    }
}
