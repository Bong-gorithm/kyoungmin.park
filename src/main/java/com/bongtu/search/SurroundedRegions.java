package com.bongtu.search;

public class SurroundedRegions {
	private final int[] dx = {-1, 0, 1, 0};
	private final int[] dy = {0, 1, 0, -1};

	private int m;
	private int n;

	public void solve(char[][] board) {
		m = board.length;
		n = board[0].length;

		for (int x = 0; x < n; x++) {
			if (board[0][x] == 'O') {
				dfs(x, 0, board);
			}

			if (board[m - 1][x] == 'O') {
				dfs(x, m - 1, board);
			}
		}

		for (int y = 0; y < m; y++) {
			if (board[y][0] == 'O') {
				dfs(0, y, board);
			}

			if (board[y][n - 1] == 'O') {
				dfs(n - 1, y, board);
			}
		}

		for (int y = 0; y < m; y++) {
			for (int x = 0; x < n; x++) {
				if (board[y][x] == 'O') {
					board[y][x] = 'X';
				} else if (board[y][x] == 'V') {
					board[y][x] = 'O';
				}
			}
		}
	}

	private void dfs(int x, int y, char[][] board) {
		board[y][x] = 'V';

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
				if(board[ny][nx] == 'O'){
					dfs(nx, ny, board);
				}
			}
		}
	}
}
