package com.bongtu.datastructure;

import java.util.*;

public class ImplementStackUsingQueues {
	private final Queue<Integer> q = new LinkedList<>();

	public ImplementStackUsingQueues() {

	}

	public void push(int x) {
		int size = q.size();

		q.offer(x);
		for (int i = 0; i < size; i++) {
			q.offer(q.poll());
		}
	}

	public int pop() {
		return q.poll();
	}

	public int top() {
		return q.peek();
	}

	public boolean empty() {
		return q.isEmpty();
	}
}
