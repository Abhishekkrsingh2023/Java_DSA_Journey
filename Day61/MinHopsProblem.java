import java.util.Arrays;

public class MinHopsProblem {
    public static int countHops(int n, int jump) {
        if (jump == n) return 1;
        if (jump > n) return 0;
        return countHops(n, jump + 1) + countHops(n, jump + 2) + countHops(n, jump + 3);
    }
    // applying the DP logic
    public static int countHops ( int n, int jump, int[] memo){
        if (jump == n) return 1;
        if (jump > n) return 0;
        if (memo[jump] != -1) return memo[jump];
        return memo[jump] = countHops(n, jump + 1, memo) + countHops(n, jump + 2, memo) + countHops(n, jump + 3, memo);
    }
    public static void main(String[] args) {
        int n = 6;
        int[] memo = new int[n + 1];
        Arrays.fill(memo,-1);
        System.out.println(countHops(n, 0, memo));
    }
}
