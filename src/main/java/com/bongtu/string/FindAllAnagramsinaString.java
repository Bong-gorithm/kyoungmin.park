package com.bongtu.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsinaString {
    public List<Integer> findAnagrams(String s, String p) {
        int[] count = new int[26];
        List<Integer> answer = new ArrayList<>();

        if (p.length() > s.length()) {
            return answer;
        }

        for (char st : p.toCharArray()) {
            count[st-'a']++;
        }

        char[] st = s.toCharArray();

        for (int i = 0; i < p.length(); i++) {
            count[st[i]-'a']--;
        }

        if(isAllZero(count)){
            answer.add(0);
        }

        for (int i = 1; i < st.length - p.length() + 1; i++) {

            count[st[i-1]-'a']++;
            count[st[i + p.length() - 1]-'a']--;

            if(isAllZero(count)) {
                answer.add(i);
            }
        }

        return answer;
    }

    private boolean isAllZero(int[] count){
        for (int c:count){
            if(c != 0){
                return false;
            }
        }
        return true;
    }

    // public List<Integer> findAnagrams(String s, String p) {
    //     Map<Character, Integer> count = new HashMap<>();
    //     List<Integer> answer = new ArrayList<>();

    //     if (p.length() > s.length()) {
    //         return answer;
    //     }

    //     for (char st : p.toCharArray()) {
    //         count.put(st, count.getOrDefault(st, 0) + 1);
    //     }

    //     char[] st = s.toCharArray();

    //     for (int i = 0; i < p.length(); i++) {
    //         count.put(st[i], count.getOrDefault(st[i], 0) - 1);
    //     }

    //     if (!count.values().stream().anyMatch((v -> v != 0))) {
    //         answer.add(0);
    //     }

    //     for (int i = 1; i < st.length - p.length() + 1; i++) {

    //         count.put(st[i - 1], count.getOrDefault(st[i - 1], 0) + 1);

    //         count.put(st[i + p.length() - 1], count.getOrDefault(st[i + p.length() - 1], 0) - 1);

    //         if (!count.values().stream().anyMatch((v -> v != 0))) {
    //             answer.add(i);
    //         }
    //     }

    //     return answer;
    // }
}
