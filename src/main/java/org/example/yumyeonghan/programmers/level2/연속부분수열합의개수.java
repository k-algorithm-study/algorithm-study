package org.example.yumyeonghan.programmers.level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://school.programmers.co.kr/learn/courses/30/lessons/131701
public class 연속부분수열합의개수 {

  public int solution(int[] elements) {
    int[] sequence = new int[elements.length * 2]; // 수열의 끝과 다시 처음과 연결해서 계산하기 위함
    Set<Integer> answer = new HashSet<>();

    for (int i = 0; i < elements.length; i++) {
      sequence[i] = elements[i];
      sequence[i + elements.length] = elements[i];
    }

    for (int len = 1; len <= elements.length; len++) {
      for (int idx = 0; idx < elements.length; idx++) {
        answer.add(Arrays.stream(sequence, idx, idx + len).sum());
      }
    }
    return answer.size();
  }

}
