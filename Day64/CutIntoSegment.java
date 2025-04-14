import java.util.Arrays;

public class CutIntoSegment {
    static final int MIN = Integer.MIN_VALUE;

    public static int getSegment(int n, int x, int y, int z) {
        if (n == 0)
            return 0; // nothing to cut
        if (n <= 0)
            return MIN; // not possible
        int xCut = 1 + getSegment(n - x, x, y, z);
        int yCut = 1 + getSegment(n - y, x, y, z);
        int zCut = 1 + getSegment(n - z, x, y, z);
        return Math.max(xCut, Math.max(yCut, zCut));
    }

    public static int getSegmentMemo(int n, int x, int y, int z, int[] memo) {
        if (n == 0)
            return 0; // nothing to cut
        if (n <= 0)
            return MIN; // not possible
        // cache
        if (memo[n] != -1)
            return memo[n];
        int xCut = 1 + getSegmentMemo(n - x, x, y, z, memo);
        int yCut = 1 + getSegmentMemo(n - y, x, y, z, memo);
        int zCut = 1 + getSegmentMemo(n - z, x, y, z, memo);
        // caching the answer
        return memo[n] = Math.max(xCut, Math.max(yCut, zCut));
    }

    // using Tabulation method
    public static int getSegTab(int n, int x, int y, int z) {
        if (n == 0)
            return 0;
        if (n < 0)
            return MIN;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, MIN);
        memo[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (i - x >= 0) {
                memo[i] = Math.max(1 + memo[i - x], memo[i]);
            }
            if (i - y >= 0) {
                memo[i] = Math.max(1 + memo[i - y], memo[i]);
            }
            if (i - z >= 0) {
                memo[i] = Math.max(1 + memo[i - z], memo[i]);
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 51;
        int x = 2, y = 3, z = 5;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        System.out.println(getSegmentMemo(n, x, y, z, memo));
        System.out.println(getSegTab(n, x, y, z));

    }
}
