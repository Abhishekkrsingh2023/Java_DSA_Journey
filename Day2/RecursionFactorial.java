// package Java_DSA_Journey.Day2;

public class RecursionFactorial {
    public static int factorial(int n) {
        if(n==0 || n==1) return 1; // base case
        return n * factorial(n-1); // recursive call
    }

    public static void main(String[] args) {
        int n = 5;
        int fact = factorial(n);
        System.out.println("The factorial of "+n +" is : "+fact);
    }
}
