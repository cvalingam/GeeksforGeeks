class Solution {
    // Directions arrays for moving in 8 possible directions
    private static final int[] rowDir = { -1, -1, -1, 0, 0, 1, 1, 1 };
    private static final int[] colDir = { -1, 0, 1, -1, 1, -1, 0, 1 };

    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        // Iterate over each cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If we encounter a '1', it's part of an unvisited island
                if (grid[i][j] == '1') {
                    numIslands++;
                    // Perform iterative DFS to mark all cells connected to this '1'
                    iterativeDFS(grid, i, j);
                }
            }
        }

        return numIslands;
    }

    private void iterativeDFS(char[][] grid, int row, int col) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] { row, col });
        grid[row][col] = '0'; // Mark the current cell as visited

        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            int r = cell[0];
            int c = cell[1];

            // Explore all 8 possible directions
            for (int d = 0; d < 8; d++) {
                int newRow = r + rowDir[d];
                int newCol = c + colDir[d];

                // Check if the new position is within bounds and still '1' (land)
                if (isValid(grid, newRow, newCol) && grid[newRow][newCol] == '1') {
                    grid[newRow][newCol] = '0'; // Mark as visited
                    stack.push(new int[] { newRow, newCol }); // Add the cell to stack for further exploration
                }
            }
        }
    }

    // Helper function to check if a cell is within grid bounds
    private boolean isValid(char[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
}