package com.bongtu.simulation;

public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        int[][] answer = new int[n][n];

        int count = 0;
        int num = 1;
        int answerLength = n*n;

        int startX = 0;
        int startY = 0;
        int endX = n - 1;
        int endY = n - 1;

        while(count != answerLength) {
            for (int i = startX; i <= endX; i++) {
                answer[startY][i] = num;
                num++;
                count++;

                if(count == answerLength) {
                    return answer;
                }
            }
            startY++;

            for (int i = startY; i <= endY; i++) {
                answer[i][endX] = num;
                num++;
                count++;

                if(count == answerLength) {
                    return answer;
                }
            }
            endX--;

            for(int i = endX; i >= startX; i--) {
                answer[endY][i] = num;
                num++;
                count++;

                if(count == answerLength) {
                    return answer;
                }
            }
            endY--;

            for(int i = endY; i >= startY; i--) {
                answer[i][startX] = num;
                num++;
                count++;

                if(count == answerLength) {
                    return answer;
                }
            }
            startX++;
        }

        return answer;
    }
}
