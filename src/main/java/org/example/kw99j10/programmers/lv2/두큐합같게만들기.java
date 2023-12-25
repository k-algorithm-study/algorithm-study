package org.example.kw99j10.programmers.lv2;

import java.util.LinkedList;

/**
 * 두 큐 합 같게 만들기, programmers:Level 2
 */
public class 두큐합같게만들기 {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        var qa = new LinkedList<Integer>();
        var qb = new LinkedList<Integer>();

        int length = queue1.length; //두 큐의 길이는 같음
        long sum1 = 0;
        long sum2 = 0;
        for (int i = 0; i < length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];

            qa.add(queue1[i]);
            qb.add(queue2[i]); //각 큐에 원소를 저장
        }

        long total = sum1 + sum2;

        //두 큐의 모든 원소의 합이 홀수이면 방법 x
        if (total % 2 != 0) {
            return -1;
        }

        //두 큐의 합이 같다면 반복문 종료
        while (sum1 != sum2) {

            //각 큐의 길이보다 계산 과정이 길어지면 각 큐의 원소 합을 같게 만들 수 없음
            if (answer > 600000) {
                return -1;
            }

            if (sum1 > sum2) {
                sum2 += qa.getFirst();
                sum1 -= qa.getFirst();
                qb.addLast(qa.removeFirst());
            }
            else {
                sum1 += qb.getFirst();
                sum2 -= qb.getFirst();
                qa.addLast(qb.removeFirst());
            }
            answer += 1; //한 번의 pop과 insert
        }
        return answer;
    }
}
