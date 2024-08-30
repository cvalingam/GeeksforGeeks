import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][];

        for (int i = 0; i < n; i++) {
            char[] s = new char[n];
            java.util.Arrays.fill(s, '.');
            board[i] = s;
        }

        solve(0, board, ans, n);

        return ans;
    }

    private void solve(int col, char[][] board, List<List<String>> ans, int n) {
        if (col == n) {
            ans.add(construct(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = 'Q';
                solve(col + 1, board, ans, n);
                board[row][col] = '.';
            }
        }
    }

    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++)
            res.add(new String(board[i]));
        return res;
    }

    private boolean isSafe(int row, int col, char[][] board, int n) {
        int r = row, c = col;
        // upper diagonal
        while (r >= 0 && c >= 0) {
            if (board[r][c] == 'Q')
                return false;
            r--;
            c--;
        }

        r = row;
        c = col;
        // left
        while (c >= 0) {
            if (board[r][c] == 'Q')
                return false;
            c--;
        }

        r = row;
        c = col;
        // lower diagonal
        while (r < n && c >= 0) {
            if (board[r][c] == 'Q')
                return false;
            r++;
            c--;
        }

        return true;
    }
}
