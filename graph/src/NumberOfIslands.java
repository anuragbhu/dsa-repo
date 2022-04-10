public class NumberOfIslands {
    // Similar to Flood-Fill Algorithm
    // DFS Approach: Time complexity: O(m*n), space complexity: O(1). m is number of rows, n is number of columns.
    private static boolean isValid(int x, int y, int m, int n, char[][] grid) {
        if((x >= 0 && x < m) && (y >= 0 && y < n) && grid[x][y] == '1')
            return true;
        return false;
    }

    public static void dfs(int x, int y, int m, int n, char[][] grid) {
        if(isValid(x, y, m, n, grid)) {
            grid[x][y] = '0';

            dfs(x - 1, y, m, n, grid);
            dfs(x + 1, y, m, n, grid);
            dfs(x, y - 1, m, n, grid);
            dfs(x, y + 1, m, n, grid);
        }
    }

    public int numIslands(char[][] grid) {

        int count = 0; // number of islands
        int m = grid.length, n = grid[0].length;

        // Do DFS and count the number of DFS calls.
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    dfs(i, j, m, n, grid);
                    count++;
                }
            }
        }
        return count;
    }
}
