import java.util.*;

class Solution {
    public int wildCard(String pattern, String str) {
        int n = pattern.length();
        int m = str.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return topDown(n, m, pattern, str, dp);
    }

    private int topDown(int i, int j, String p, String s, int[][] dp) {
        if (i == 0 && j == 0)
            return 1;
        if (i == 0 && j > 0)
            return 0;
        if (i > 0 && j == 0) {
            for (int k = 1; k <= i; k++) {
                if (p.charAt(k - 1) != '*')
                    return 0;
            }
            return 1;
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        if (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?')
            return dp[i][j] = topDown(i - 1, j - 1, p, s, dp);

        if (p.charAt(i - 1) == '*')
            return dp[i][j] = topDown(i - 1, j, p, s, dp) | topDown(i, j - 1, p, s, dp);

        dp[i][j] = 0;
        return dp[i][j];
    }
}
