package org.example.hcu55.programmers.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 명예의 전당, Programmers(Level 1)
public class 명예의전당 {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> honor = new ArrayList<>();    // 명예의 전당 리스트

        for (int i = 0; i < score.length; i++) {
            honor.add(score[i]);                  // 하나씩 뽑아서 넣을건데

            if (honor.size() > k) {               // 명예의 전당 리스트가 k보다 커지면
                Collections.sort(honor);          // 정렬 한 후
                honor.remove(0);            // 젤 작은값 삭제
            }
            answer[i] = Collections.min(honor);   // 젤 작은 값은 결과 배열에 넣기
        }
        return answer;
    }
}
