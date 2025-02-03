// package Java_DSA_Journey.Day3;

public class FibonacciNumber {
    public static int fibo(int n) {
        if(n==0 || n==1) return 0; // base case for 0th and 1st term
        if(n==2) return 1; // for 2nd term
        return fibo(n-1) + fibo(n-2);
    }
    public static void main(String[] args) {
        System.out.println(fibo(8));
    }
}
