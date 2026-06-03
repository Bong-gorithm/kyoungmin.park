package com.bongtu.string;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int answer = 0;
        boolean hasOdd = false;
        for (int i : map.values()) {

            if (i % 2 == 0) {
                answer += i;
            } else {
                answer += i - 1;
                hasOdd = true;
            }
        }

        if (hasOdd) {
            answer++;
        }

        return answer;
    }
}
