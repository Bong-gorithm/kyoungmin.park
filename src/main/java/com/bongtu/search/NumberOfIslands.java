package com.bongtu.search;

public class NumberOfIslands {
    private final int[] dx = { -1, 0, 1, 0 };
    private final int[] dy = { 0, 1, 0, -1 };
    private int m;
    private int n;
    private int count;

    public int numIslands(char[][] grid) {
        count = 0;
        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(j, i, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int x, int y, char[][] grid) {
        grid[y][x] = '0';

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (grid[ny][nx] == '1') {
                    dfs(nx, ny, grid);
                }
            }
        }
    }
}
