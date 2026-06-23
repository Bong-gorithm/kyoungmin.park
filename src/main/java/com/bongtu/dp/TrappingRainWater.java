package com.bongtu.dp;

public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int[] water = new int[n];

        water[0] = 0;
        int max = height[0];
        for (int i = 1; i < n; i++) {
            water[i] = max;
            if (height[i] > max) {
                max = height[i];
            }
        }

        water[n - 1] = 0;
        max = height[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            if (water[i] > max) {
                water[i] = max;
            }
            if (height[i] > max) {
                max = height[i];
            }
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (water[i] - height[i] > 0) {
                answer += water[i] - height[i];
            }
        }

        return answer;
    }

    public int trap2(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int answer = 0;

        while (left < right) {

            if (height[left] < height[right]) {

                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    answer += leftMax - height[left];
                }

                left++;

            } else {

                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    answer += rightMax - height[right];
                }

                right--;
            }
        }

        return answer;
    }
}
