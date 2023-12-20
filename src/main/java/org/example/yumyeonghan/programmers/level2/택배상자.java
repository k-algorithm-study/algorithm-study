package org.example.yumyeonghan.programmers.level2;

import java.util.Deque;
import java.util.LinkedList;

// https://school.programmers.co.kr/learn/courses/30/lessons/131704
public class 택배상자 {

  public int solution(int[] order) {
    int answer = 0;
    int idx = 0;
    int lastBox = order.length;
    Deque<Integer> auxiliaryContainer = new LinkedList<>();

    // 1번 상자부터 확인
    for (int box = 1; box <= lastBox; box++) {
      // 메인 컨테이너 확인
      if (order[idx] != box) {
        auxiliaryContainer.push(box);
      } else {
        idx += 1;
        answer += 1;
      }
      // 보조 컨테이너 확인
      while (!auxiliaryContainer.isEmpty() && auxiliaryContainer.peek() == order[idx]) {
        auxiliaryContainer.pop();
        idx += 1;
        answer += 1;
      }
    }
    return answer;
  }

}
