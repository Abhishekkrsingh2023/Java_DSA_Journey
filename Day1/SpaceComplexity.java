// package Java_DSA_Journey.Day1;

public class SpaceComplexity {
    public static void main(String[] args) {
        int a = 5; // O(1) space
        int[] arr = new int[10]; // O(n) space where n is the size of the array

        // Example of O(n) space complexity
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * i;
        }

        // Example of O(1) space complexity
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        System.out.println("Sum of squares: " + sum);
    }
}
