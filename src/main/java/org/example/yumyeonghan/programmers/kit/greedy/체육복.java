package org.example.yumyeonghan.programmers.kit.greedy;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/42862
public class 체육복 {

  public int solution(int n, int[] lost, int[] reserve) {
    Arrays.sort(lost);
    Arrays.sort(reserve);
    int answer = n - lost.length;

    for (int l = 0; l < lost.length; l++) {
      for (int r = 0; r < reserve.length; r++) {
        if (lost[l] == reserve[r]) {
          answer += 1;
          lost[l] = -1;
          reserve[r] = -1;
          break;
        }
      }
    }

    for (int l = 0; l < lost.length; l++) {
      for (int r = 0; r < reserve.length; r++) {
        if (lost[l] + 1 == reserve[r] || lost[l] - 1 == reserve[r]) {
          answer += 1;
          reserve[r] = -1;
          break;
        }
      }
    }
    return answer;
  }

}
