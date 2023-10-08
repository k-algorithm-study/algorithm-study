package org.example.yumyeonghan.programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

// https://school.programmers.co.kr/learn/courses/30/lessons/181188
public class 요격시스템 {

    public int solution(int[][] targets) {
        int answer = 1;
        Arrays.sort(targets, Comparator.comparing(target -> target[0]));
        int start = targets[0][0];
        int end = targets[0][1];
        for (int i = 1; i < targets.length; i++) {
            int newStart = targets[i][0];
            int newEnd = targets[i][1];
            if (newStart < end) {
                start = Math.max(start, newStart);
                end = Math.min(end, newEnd);
            } else {
                start = newStart;
                end = newEnd;
                answer += 1;
            }
        }
        return answer;
    }

}
