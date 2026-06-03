package com.bongtu.dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] count = new int[amount + 1];
        Arrays.fill(count, -1);
        Queue<Integer> q = new LinkedList<>();

        count[amount] = 0;
        q.offer(amount);

        while (!q.isEmpty()) {
            int current = q.poll();
            for (int c : coins) {
                int next = current - c;
                if (next >= 0) {
                    if (count[next] == -1) {
                        q.offer(next);
                        count[next] = count[current] + 1;
                    }
                }
            }
        }

        return count[0];
    }
}
