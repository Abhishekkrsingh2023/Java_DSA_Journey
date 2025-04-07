import java.util.HashMap;

public class DPfibo {
    // normal way of calculating the nth fibonacci number
    public static int normalFibo(int n) {
        if (n <= 2) return 1;
        return normalFibo(n - 1) + normalFibo(n - 2);
    }

    // using memoization(DP approach)(top -> bottom)
    public static int dpFibo(int n, HashMap<Integer, Integer> memo) {
        // checking in the cache
        if (memo.containsKey(n)) return memo.get(n);
        if (n <= 2) return 1;
        int ans = dpFibo(n - 1, memo) + dpFibo(n - 2, memo);
        // updating in the memo
        memo.put(n, ans);
        // returning the value
        return memo.get(n);
    }

    // bottom -> top approach using iteration
    public static int iterFibo(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        if (n <= 2) return 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    // optimized space complexity
    public static int iterFiboOptimized(int n) {
        if (n <= 2) return 1;
        int a = 0, b = 1, c = 0;
        int i = 2;
        while (i++ <= n) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> memo = new HashMap<>();
//        System.out.println(normalFibo(45)); // O(2^n)
//        System.out.println(dpFibo(45, memo)); // O(n)
//        System.out.println(iterFibo(45));
        System.out.println(iterFiboOptimized(6));
        System.out.println(iterFiboOptimized(7));
    }
}
