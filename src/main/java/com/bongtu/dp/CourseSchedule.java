package com.bongtu.dp;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    private int[] state;
    private List<Integer>[] graph;

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        state = new int[numCourses];
        graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[1]].add(prerequisite[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int course) {
        if (state[course] == 1) {
            return false;
        }

        if (state[course] == 2) {
            return true;
        }

        state[course] = 1;

        for (int next : graph[course]) {
            if (!dfs(next)) {
                return false;
            }
        }

        state[course] = 2;

        return true;
    }
}
