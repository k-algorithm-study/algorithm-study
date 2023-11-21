package org.example.hcu55.programmers.level2;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

// 디펜스 게임, Programmers(Level 2)
public class 디펜스게임 {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder()); // 라운드 별 적의 수 큰 거부터 우선순위

        int mySoldier = n;      // 내 병사 수
        int skill = k;          // 무적권 개수
        for (int i = 0; i < enemy.length; i++) {
            mySoldier -= enemy[i];  // 라운드 병사 수 만큼 뺌
            queue.add(enemy[i]);    // 병사 수는 큐에 넣음

            if (mySoldier < 0) {    // 계속 라운드 진행하다가 병사 수가 음수될때
                if (skill > 0 && !queue.isEmpty()) {    // 무적권이 남아 있고 큐에 적이 존재할때
                    mySoldier += queue.poll();      // 제일 큰 적의 수 빼서 현재 내 병사에 추가
                    skill--;    // 무적권 하나 씀
                } else {    // 없다면
                    answer = i;     // 현재 라운드가 최종 라운드
                    break;
                }
            }
            answer++;       // 적의 수 빼도 병사가 음수가 아니라면 다음 라운드
        }
        return answer;
    }
}
