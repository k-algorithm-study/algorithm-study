package org.example.hcu55.programmers.level2;

import java.util.Arrays;

// 요격 시스템, Programmers(Level 2)
public class 요격시스템 {
    public int solution(int[][] targets) {
        int answer = 0;
        int before = 0;

        Arrays.sort(targets, (a, b) -> a[1] - b[1]);
        for (int i = 0; i < targets.length; i++) {
            if (targets[i][0] >= before) {
                before = targets[i][1];
                answer++;
            }
        }
        return answer;
    }
}
