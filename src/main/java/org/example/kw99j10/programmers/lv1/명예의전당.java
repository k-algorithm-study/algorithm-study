package org.example.kw99j10.programmers.lv1;

import java.util.PriorityQueue;

public class 명예의전당 {
    public static int[] solution(int k, int[] score) {

        int[] answer = new int[score.length];

        //명예의 전당 점수를 담을 우선순위 큐: k번째 보다 낮은 점수 -> 퇴장
        PriorityQueue<Integer> honor = new PriorityQueue<>();

        for (int i = 0; i < score.length; i++) {

            honor.offer(score[i]); //현재 점수를 큐에 저장

            if (!honor.isEmpty()) {

                if (honor.size() > k) {
                    honor.poll(); //k번째 보다 낮은 점수이면 해당 점수를 제거
                }

                answer[i] = honor.element(); //명예의 전당 최하위 점수를 저장
            }
        }
        return answer;
    }
}
