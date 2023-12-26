package org.example.yumyeonghan.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/118667
public class 두큐합같게만들기 {

  public int solution(int[] queue1, int[] queue2) {
    int answer = 0;

    // init queue
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    long sum1 = 0;
    long sum2 = 0;
    for (int i = 0; i < queue1.length; i++) {
      q1.add(queue1[i]);
      sum1 += queue1[i];

      q2.add(queue2[i]);
      sum2 += queue2[i];
    }
    int size1 = q1.size();
    int size2 = q2.size();

    // search queue
    while (sum1 != sum2) {

      // 합이 더 큰 큐에서 합이 더 작은 큐로 삽입
      if (sum1 > sum2) {
        size1--;
        Integer popNumber = q1.poll();
        q2.add(popNumber);
        sum1 -= popNumber;
        sum2 += popNumber;
      } else {
        size2--;
        Integer popNumber = q2.poll();
        q1.add(popNumber);
        sum1 += popNumber;
        sum2 -= popNumber;
      }

      // 만약 pop의 횟수가 큐의 원래의 길이와 같다면, 큐의 원소를 전부 사용해도 합이 같아지지 않는다는 의미이므로 -1 반환
      if (size1 <= 0 && size2 <= 0) {
        return -1;
      }

      // 삽입 과정이 끝나면 횟수 + 1
      answer++;
    }
    return answer;
  }

}
