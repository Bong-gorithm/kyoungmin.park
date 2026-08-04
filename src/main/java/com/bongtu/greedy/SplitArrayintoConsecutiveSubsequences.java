package com.bongtu.greedy;

import java.util.HashMap;
import java.util.Map;

public class SplitArrayintoConsecutiveSubsequences {
    private Map<Integer, Integer> count = new HashMap<>();
    private Map<Integer, Integer> tail = new HashMap<>();

    public boolean isPossible(int[] nums) {

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (count.get(num) == 0) {
                continue;
            }

            count.put(num, count.get(num) - 1);

            if (tail.getOrDefault(num - 1, 0) > 0) {
                tail.put(num - 1, tail.get(num - 1) - 1);
                tail.put(num, tail.getOrDefault(num, 0) + 1);
            } else if (count.getOrDefault(num + 1, 0) > 0
                    && count.getOrDefault(num + 2, 0) > 0) {

                count.put(num + 1, count.get(num + 1) - 1);
                count.put(num + 2, count.get(num + 2) - 1);

                tail.put(num + 2, tail.getOrDefault(num + 2, 0) + 1);
            } else {
                return false;
            }
        }

        return true;
    }
}
