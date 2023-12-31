package org.example.kw99j10.programmers.lv2;

/**
 *  n^2 배열 자르기, programmers:Level 2
 */
public class n2배열자르기 {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];

        //문제 조건에 따른 범위를 1차원 배열에 집어 넣음
        for (int i = 0; i < answer.length; i++) {

            int start = (int) (left / n + 1);
            int end = (int) (left % n + 1);
            answer[i] = Math.max(start, end);
            left += 1;
        }
        return answer;
    }
}
