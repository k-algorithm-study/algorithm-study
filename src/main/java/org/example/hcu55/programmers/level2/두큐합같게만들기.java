package org.example.hcu55.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

// 두 큐 합 같게 만들기, Programmers(Level 2)
public class 두큐합같게만들기 {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> que1 = new LinkedList<>();       // 큐 2개 생성
        Queue<Integer> que2 = new LinkedList<>();

        long sum1 = 0, sum2 = 0;

        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];          // 큐 1의 합
            que1.offer(queue1[i]);
        }

        for (int i = 0; i < queue2.length; i++) {
            sum2 += queue2[i];          // 큐 2의 합
            que2.offer(queue2[i]);
        }

        while (sum1 != sum2) {       // 각 큐의 합이 같을 때까지 반복

            if (sum1 > sum2) {               // 1번 큐의 합이 크면
                int num = que1.poll();      // 1번 큐에서 하나 꺼내서
                sum1 -= num;
                sum2 += num;
                que2.offer(num);            // 2번 큐에 넣어줌
            } else {
                int num = que2.poll();
                sum1 += num;
                sum2 -= num;
                que1.offer(num);
            }
            answer++;

            if (answer > (queue1.length + queue2.length) * 2) {   // 종료 조건 추가 (큐1의 길이+큐2의 길이) * 2만큼 보다 크면 불가능
                return -1;
            }
        }
        return answer;
    }
}
