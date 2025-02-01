public class TimeComplexity {

    // O(1) - Constant time complexity
    public static void constantTime(int n) {
        System.out.println("constant time complexity.");
    }

    // O(log n) - Logarithmic time complexity
    public static void logarithmicTime(int n) {
        System.out.println("Logarithmic time complexity");
        while (n > 1) {
            n = n / 2;
            System.out.println(n);
        }
    }

    // O(n) - Linear time complexity
    public static void linearTime(int n) {
        System.out.println("Linear Time complexity");
        for (int i = 0; i < n; i++) {
            System.out.println(i);
        }
    }

    // O(n log n) - Linearithmic time complexity(eg- Merge Sort)
    public static void linearithmicTime(int n) {
        System.out.println("linearithmicTime Time complexity");

        for (int i = 0; i < n; i++) {
            int j = 1;
            while (j < n) {
                j = j * 2;
            }
        }
    }

    // O(n^2) - Quadratic time complexity
    public static void quadraticTime(int n) {
        System.out.println("quadraticTime Time complexity");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(i + " " + j);
            }
        }
    }

    public static void main(String[] args) {
        int n = 10;
        constantTime(n);
        logarithmicTime(n);
        linearTime(n);
        linearithmicTime(n);
        quadraticTime(n);
    }
}