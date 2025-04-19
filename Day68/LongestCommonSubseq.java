// package Day68;

import java.util.Arrays;

public class LongestCommonSubseq {
    public static int getCount(String s1, String s2, int i1, int i2) {
        if (i1 < 0 || i2 < 0)
            return 0;

        if (s1.charAt(i1) == s2.charAt(i2))
            return 1 + getCount(s1, s2, i1 - 1, i2 - 1);
        else
            return Math.max(getCount(s1, s2, i1 - 1, i2), getCount(s1, s2, i1, i2 - 1));
    }

    // memoized code
    public static int getCount(String s1, String s2, int i1, int i2, int[][] memo) {
        if (i1 < 0 || i2 < 0)
            return 0;
        if (memo[i1][i2] != -1)
            return memo[i1][i2];

        if (s1.charAt(i1) == s2.charAt(i2))
            return memo[i1][i2] = 1 + getCount(s1, s2, i1 - 1, i2 - 1, memo);
        else
            return memo[i1][i2] = Math.max(getCount(s1, s2, i1 - 1, i2, memo), getCount(s1, s2, i1, i2 - 1, memo));
    }

    // Tabulation
    public static int getCountTab(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String s1 = "abcdfxydfgeejehfsbndpondkjnsdf";
        String s2 = "becfdedcfdfsdgbk fdsfkndfv ";
        int memo[][] = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            Arrays.fill(memo[i], -1);
        }

        System.out.println(getCount(s1, s2, s1.length() - 1, s2.length() - 1, memo));
        // System.out.println(getCount(s1, s2, s1.length() - 1, s2.length() - 1));
        System.out.println(getCountTab(s1, s2));
    }
}
