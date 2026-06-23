package com.bongtu.math;

public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        Integer first = null, second = null, third = null;

        for (int num : nums) {
            int x = num;

            if (first != null && first == x
                    || second != null && second == x
                    || third != null && third == x) {
                continue;
            }

            if (first == null || x > first) {
                third = second;
                second = first;
                first = x;
            } else if (second == null || x > second) {
                third = second;
                second = x;
            } else if (third == null || x > third) {
                third = x;
            }
        }

        return third == null ? first.intValue() : third.intValue();
    }
}
