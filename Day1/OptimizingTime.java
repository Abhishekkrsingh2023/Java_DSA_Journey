// package Java_DSA_Journey.Day1;

public class OptimizingTime {
    public static int sumUsingFormula(int n) {
        return n * (n + 1) / 2;
    }

    public static int sumUsingLoop(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
    public static void main(String[] args) {
        // 2 different solutions

        int sum = sumUsingFormula(100);// O(1) time complexity
        int sum2 = sumUsingLoop(100); // O(n) time complexity

        System.out.println(sum);
        System.out.println(sum2);
    }
}
