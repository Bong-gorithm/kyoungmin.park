package com.bongtu.search;

public class BeautifulArrangement {
    private int answer = 0;

    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        dfs(1, n, visited);
        return answer;
    }

    private void dfs(int idx, int n, boolean[] visited) {
        if (idx > n) {
            answer++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }

            if (i % idx == 0 || idx % i == 0) {
                visited[i] = true;
                dfs(idx + 1, n, visited);
                visited[i] = false;
            }
        }
    }
}
