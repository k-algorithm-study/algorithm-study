package org.example.yumyeonghan.programmers.level2;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/147354
public class 테이블해시함수 {

  public int solution(int[][] data, int col, int row_begin, int row_end) {
    int answer = 0;
    Arrays.sort(data, (o1, o2) -> {
      if (o1[col - 1] == o2[col - 1]) {
        return o2[0] - o1[0];
      }
      return o1[col - 1] - o2[col - 1];
    });
    for (int i = row_begin - 1; i < row_end; i++) {
      int sum = 0;
      for (int c : data[i]) {
        sum += (c % (i + 1));
      }
      answer ^= sum; // ^: XOR 연산자
    }
    return answer;
  }

}
