package com.bongtu.simulation;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        // 위, 오른쪽, 아래, 왼쪽 순으로 탐색을 하는데 탐색 과정에서 범위를 좁히기
        // 각 원소 추가 시에 카운트 상태를 보고 종료

        int width = matrix[0].length;
        int height = matrix.length;

        List<Integer> answer = new ArrayList<>();

        int count = 0;

        int startX = 0;
        int startY = 0;
        int endX = width - 1;
        int endY = height - 1;

        while(count != width * height) {
            for (int i = startX; i <= endX; i++) {
                answer.add(matrix[startY][i]);
                count++;
                if(count == width * height) {
                    return answer;
                }
            }

            startY++;

            for (int i = startY; i <= endY; i++) {
                answer.add(matrix[i][endX]);
                count++;
                if(count == width * height) {
                    return answer;
                }
            }

            endX--;

            for (int i = endX; i >= startX; i--) {
                answer.add(matrix[endY][i]);
                count++;
                if(count == width * height) {
                    return answer;
                }
            }
            endY--;

            for (int i = endY; i >= startY; i--) {
                answer.add(matrix[i][startX]);
                count++;
                if(count == width * height) {
                    return answer;
                }
            }
            startX++;
        }

        return answer;
    }
}
