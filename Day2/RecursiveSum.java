// package Java_DSA_Journey.Day2;

public class RecursiveSum {
    // method that finds sum of first n natural number
    public static int sum(int n) {
        if(n==0) return 0; // base case
        return n + sum(n-1); // recursive sun problem
    }

    public static void main(String[] args) {
        int n=10;
        System.out.println(sum(10));
    }
}
