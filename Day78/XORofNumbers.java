// package Day78;

public class XORofNumbers {
    public static int getXor(int n) {
        int rem = n % 4;
        if (rem == 0) {
            return n;
        } else if (rem == 1) {
            return 1;
        } else if (rem == 2) {
            return n + 1;
        } else {
            return 0;
        }
    }
    // Xor from x to y is equal to xor(1 to y) ^ xor(1 to x-1)
    public static int getXor(int x, int y) {
        return getXor(y) ^ getXor(x - 1);
    }
    public static void main(String[] args) {
        System.out.println("XOR of numbers from 1 to 5 is: " + getXor(5));
        System.out.println("XOR of numbers from 1 to 10 is: " + getXor(10));
        System.out.println("XOR of numbers from 1 to 19 is: " + getXor(19));

        // XOR of numbers from 5 to 10
        System.out.println("XOR of numbers from 5 to 10 is: " + getXor(5, 10));
    }
}
