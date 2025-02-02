// package Java_DSA_Journey.Day2;

public class PrintNumber {
    // function to print numbers from n to 1
    public static void printNumbers(int n) {
        if (n < 1) return;
        System.out.println(n);
        printNumbers(n - 1);
    }

    public static void main(String[] args) {
        int n = 10; // Example value
        printNumbers(n);
    }
}
