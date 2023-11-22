package org.example.yumyeonghan.programmers.level2;

public class 점찍기 {

  public long solution(int k, int d) {
    long answer = 0;
    for (long i = 0; i <= d / k; i++) {
      long x = i * k;
      // 원의 방정식 x^2 + y^2 = d^2
      long y = (long) Math.sqrt((long) Math.pow(d, 2) - (long) Math.pow(x, 2)) / k;
      answer += y;
    }
    return answer + d / k + 1;
  }

}
