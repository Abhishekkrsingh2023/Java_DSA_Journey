// package Day71;

import java.util.Arrays;
import java.util.Random;

public class MatricChainMultiplication {
    // Recursive code
    public static long getSteps(int[] arr, int i, int j) {
        if (i == j)
            return 0;
        long min = Long.MAX_VALUE;
        // exploring all the partitions
        for (int k = i; k < j; k++) {
            long steps = (long) (arr[i - 1] * arr[k] * arr[j]) + getSteps(arr, i, k) + getSteps(arr, k + 1, j);
            min = Math.min(min, steps);
        }
        return min;
    }

    // Recursion + Memoization
    public static long getSteps(int[] arr, int i, int j, long[][] memo) {
        if (i == j)
            return 0;
        if (memo[i][j] != -1)
            return memo[i][j];
        long min = Long.MAX_VALUE;
        for (int k = i; k < j; k++) {
            long steps = (long) (arr[i - 1] * arr[k] * arr[j])
                    + getSteps(arr, i, k, memo)
                    + getSteps(arr, k + 1, j, memo);
            min = Math.min(min, steps);
        }
        memo[i][j] = min;
        return min;
    }

    public static void main(String[] args) {
        int[] arr = { 20, 30, 40, 45 }; // dimensions of the Matrix (n-1) matrices
        int n = arr.length;
        int i = 1;
        long memo[][] = new long[n][n];
        // Initializing memoization array with -1
        for (int j = 0; j < n; j++) {
            Arrays.fill(memo[j], -1);
        }
        // Recursive code
        System.out.println(getSteps(arr, i, n - 1));
        // Memoization code
        System.out.println(getSteps(arr, i, n - 1, memo));

        // Largest Matrix Chain Multiplication
        Random random = new Random();
        int size = 22; // Size of the array
        int[] largeArr = new int[size];
        // Generating random dimensions for the matrices
        for (int j = 0; j < size; j++) {
            largeArr[j] = random.nextInt(100) + 1; // Random dimensions between 1 and 100
        }
        // Measuring time for recursive code
        long startTime = System.nanoTime();
        System.out.println(getSteps(largeArr, 1, size - 1));
        long endTime = System.nanoTime();
        long duration = endTime - startTime; // Duration in nanoseconds
        System.out.println("Time taken for recursive code: " + duration / 1000000000 + " seconds");

        // Measuring time for memoization code
        long[][] memoLarge = new long[size][size];
        // Initializing memoization array with -1
        for (int j = 0; j < size; j++) {
            Arrays.fill(memoLarge[j], -1);
        }
        startTime = System.nanoTime();
        System.out.println(getSteps(largeArr, 1, size - 1, memoLarge));
        endTime = System.nanoTime();
        duration = endTime - startTime; // Duration in nanoseconds
        System.out.println("Time taken for memoization code: " + duration / 100000000 + " seconds");

    }
}
