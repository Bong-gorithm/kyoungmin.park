package com.bongtu.greedy;

public class Candy {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        int answer = 0;

        candies[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i + 1] < ratings[i]) {
                if(candies[i + 1] + 1>candies[i]){
                    candies[i] = candies[i + 1] + 1;
                }
            }
        }

        for (int candy : candies) {
            answer += candy;
        }

        return answer;
    }
}
