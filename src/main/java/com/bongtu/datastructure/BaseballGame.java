package com.bongtu.datastructure;

import java.util.Stack;

public class BaseballGame {
    public int calPoints(String[] operations) {
        Stack<Integer> s = new Stack<>();

        int answer = 0;

        for (String operation : operations) {
            if (operation.equals("+")) {
                int operand1 = s.pop();
                int operand2 = s.peek();

                s.push(operand1);
                s.push(operand1 + operand2);
            } else if (operation.equals("D")) {
                s.push(s.peek() * 2);
            } else if (operation.equals("C")) {
                s.pop();
            } else {
                s.push(Integer.parseInt(operation));
            }
        }

        while (!s.isEmpty()) {
            answer += s.pop();
        }

        return answer;
    }
}
