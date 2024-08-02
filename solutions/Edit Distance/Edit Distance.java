import java.util.*;

class Solution {
    public int editDistance(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n][m];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return topDown(n - 1, m - 1, str1, str2, dp);
    }

    private int topDown(int i, int j, String s1, String s2, int[][] dp) {
        if (i < 0)
            return j + 1;

        if (j < 0)
            return i + 1;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = topDown(i - 1, j - 1, s1, s2, dp);
        else
            return dp[i][j] = 1 + Math.min(topDown(i - 1, j - 1, s1, s2, dp),
                    Math.min(topDown(i - 1, j, s1, s2, dp), topDown(i, j - 1, s1, s2, dp)));
    }
}