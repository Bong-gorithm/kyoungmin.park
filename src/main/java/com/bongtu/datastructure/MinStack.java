package com.bongtu.datastructure;

import java.util.*;

public class MinStack {
	private final Stack<Integer> s = new Stack<>();
	private final Stack<Integer> ms = new Stack<>();

	public MinStack() {

	}

	public void push(int val) {
		s.push(val);

		if (ms.isEmpty() || ms.peek() >= val) {
			ms.push(val);
		}
	}

	public void pop() {
		// 여기서 'ms.peek() == s.pop()'를 하면 객체 비교가 발생하므로 주의
		int val = s.pop();
		if (ms.peek() == val) {
			ms.pop();
		}
	}

	public int top() {
		return s.peek();
	}

	public int getMin() {
		return ms.peek();
	}
}
