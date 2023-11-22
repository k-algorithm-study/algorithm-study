package org.example.kw99j10.programmers.lv2;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 디펜스 게임, programmers:Level 2
 */
public class 디펜스게임 {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        //모든 라운드를 막을 수 있는 경우(무적권 개수 == 적 배열의 길이)
        if (k == enemy.length) {
            return enemy.length;
        }

        //무적권 사용 여부를 판단하기 위함 & 우선순위 큐 내림차순 정렬
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < enemy.length; i++) {

            //병사가 부족하고 무적권이 없다면 공격을 막을 수 없으므로 반복문 종료
            if (n < enemy[i] && k == 0) {
                break;
            }

            queue.offer(enemy[i]);

            //현재 적보다 병사 수가 부족하면
            //최소로 병사 수를 소비한 라운드를 다시 병사 수에 더한 후 무적권 사용
            if (!queue.isEmpty() && enemy[i] > n) {
                n += queue.poll();
                k -= 1;
            }

            n -= enemy[i];
            answer += 1; //막을 수 있는 라운드는 계속 증가
        }
        return answer;
    }
}
