package org.example.yumyeonghan.programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/178870
public class 연속된부분수열의합 {

  public int[] solution(int[] sequence, int k) {
    int start = 0;
    int end = 0;
    int[] answer = {start, end};
    int sum = 0;
    int minLen = Integer.MAX_VALUE;

    for (end = 0; end < sequence.length; end++) {
      sum += sequence[end];
      while (sum > k) {
        sum -= sequence[start];
        start += 1;
      }
      if (sum == k) {
        int len = end - start;
        if (len < minLen) {
          minLen = len;
          answer[0] = start;
          answer[1] = end;
        }
      }
    }
    return answer;
  }

}
