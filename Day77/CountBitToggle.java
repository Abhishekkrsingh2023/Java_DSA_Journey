// package Day77;

public class CountBitToggle {
    public static int countToggle(int x, int y) {
        int num = x ^ y;
        int cnt = 0;
        while (num != 0) {
            cnt++;
            num = num & (num - 1);
        }
        return cnt;
    }

    public static int setBit(int n, int pos) {
        return n | (1 << pos);
    }

    public static int clearBit(int n, int pos) {
        return n & (n-1);
    }

    public static int toggleBit(int n, int pos) {
        return n ^ (1 << pos);
    }

    public static void main(String[] args) {
        int x = 7, y = 11;
        System.out.println(countToggle(x, y));

        int n = 5, pos = 1;
        System.out.println("Set bit: " + setBit(n, pos));
        System.out.println("Clear bit: " + clearBit(n, pos));
        System.out.println("Toggle bit: " + toggleBit(n, pos));
    }
}
