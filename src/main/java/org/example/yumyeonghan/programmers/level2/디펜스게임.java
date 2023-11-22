package org.example.yumyeonghan.programmers.level2;

import java.util.PriorityQueue;

// https://school.programmers.co.kr/learn/courses/30/lessons/142085
public class 디펜스게임 {

  public int solution(int n, int k, int[] enemy) {
    int answer = 0;
    if (k == enemy.length) {
      return k;
    }
    int count = 0;
    int remainSoldier = n;
    // 큰수부터 나오게 함
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
    int i;
    for (i = 0; i < enemy.length; i++) {
      int currentEnemy = enemy[i];
      priorityQueue.add(currentEnemy);
      remainSoldier -= currentEnemy;
      if (remainSoldier < 0) {
        // 무적권이 남아있다면, 사용 그렇지 않으면 종료
        if (count < k) {
          remainSoldier += priorityQueue.poll();
          count++;
        } else {
          break;
        }
      }
    }
    answer = i;
    return answer;
  }

}
