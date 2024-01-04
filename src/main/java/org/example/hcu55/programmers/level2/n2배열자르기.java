package org.example.hcu55.programmers.level2;

// n^2 배열 자르기, Programmers(Level 2)
public class n2배열자르기 {
    public int[] solution(int n, long left, long right) {
        int len = (int) right - (int) left;
        int[] answer = new int[len + 1];

        int idx = 0;
        for (long i = left; i <= right; i++) {
            long row = i / n;
            long col = i % n;
            answer[idx++] = Math.max((int)row, (int)col) + 1;
        }
        return answer;
    }
}