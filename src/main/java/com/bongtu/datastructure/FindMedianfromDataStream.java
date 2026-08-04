package com.bongtu.datastructure;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianfromDataStream {
    PriorityQueue<Integer> low;
    PriorityQueue<Integer> high;

    public FindMedianfromDataStream() {
        low = new PriorityQueue<>(Collections.reverseOrder());
        high = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (low.isEmpty() || num <= low.peek()) {
            low.offer(num);
        } else {
            high.offer(num);
        }

        if (low.size() > high.size() + 1) {
            high.offer(low.poll());
        } else if (high.size() > low.size()) {
            low.offer(high.poll());
        }
    }

    public double findMedian() {
        if (low.size() == high.size()) {
            return (low.peek() + high.peek()) / 2.0;
        }
        return low.peek();
    }    
}
