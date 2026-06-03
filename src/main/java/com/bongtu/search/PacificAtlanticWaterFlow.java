package com.bongtu.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
    private final int[] dx = {1, -1, 0, 0};
    private final int[] dy = {0, 0, 1, -1};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int r = 0; r < m; r++) {
            dfs(heights, pacific, r, 0);
            dfs(heights, atlantic, r, n - 1);
        }

        for (int c = 0; c < n; c++) {
            dfs(heights, pacific, 0, c);
            dfs(heights, atlantic, m - 1, c);
        }

        List<List<Integer>> answer = new ArrayList<>();

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    answer.add(Arrays.asList(r, c));
                }
            }
        }

        return answer;
    }

    private void dfs(int[][] heights, boolean[][] visited, int x, int y) {
        int m = heights.length;
        int n = heights[0].length;

        if (visited[x][y]) {
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                continue;
            }

            if (heights[nx][ny] >= heights[x][y]) {
                dfs(heights, visited, nx, ny);
            }
        }
    }
}
