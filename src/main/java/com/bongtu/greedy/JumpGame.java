package com.bongtu.greedy;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) {
                return false;
            }

            if (i + nums[i] > farthest) {
                farthest = i + nums[i];
            }
        }

        return farthest >= nums.length - 1;
    }
}
