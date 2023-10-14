package org.example.yumyeonghan.programmers.kit.sort;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/42748
public class K번째수 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new K번째수().solution(
                                new int[]{1, 5, 2, 6, 3, 7, 4},
                                new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}
                        )
                )
        );
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int answerIndex = 0;

        for (int[] command : commands) {
            int start = command[0] - 1;
            int end = command[1];
            int idx = command[2] - 1;
            int[] newArray = Arrays.copyOfRange(array, start, end);
            Arrays.sort(newArray);
            answer[answerIndex] = newArray[idx];
            answerIndex += 1;
        }
        return answer;
    }

}
