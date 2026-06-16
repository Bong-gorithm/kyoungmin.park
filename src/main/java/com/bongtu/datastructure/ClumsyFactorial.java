package com.bongtu.datastructure;

import java.util.Stack;

public class ClumsyFactorial {
    public int clumsy(int n) {

        int answer = 0;
        int current = n - 1;

        Stack<Integer> s = new Stack<>();

        s.push(n);
        for (int i = 1; i < n; i++) {

            if (i % 4 == 1) {
                s.push(s.pop() * current);
            } else if (i % 4 == 2) {
                s.push(s.pop() / current);
            } else if (i % 4 == 3) {
                s.push(current);
            } else {
                s.push(current * -1);
            }
            current--;
        }

        while (!s.isEmpty()) {
            answer += s.pop();
        }

        return answer;
    }
}
