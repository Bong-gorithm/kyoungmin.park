package com.bongtu.array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
		List<String> answer = new ArrayList<>();

		int start = 0;

		for (int i = 1; i <= nums.length; i++) {
			if (i == nums.length || nums[i] - nums[i - 1] != 1) {
				if (start == i - 1) {
					answer.add(String.valueOf(nums[start]));
				} else {
					answer.add(nums[start] + "->" + nums[i - 1]);
				}

				start = i;
			}
		}

		return answer;
	}
}
