package org.example.yumyeonghan.programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/181187
public class 두원사이의정수쌍 {

  public long solution(int r1, int r2) {
    //x^2 + y^2 = r^2
    long answer = 0;
    for (int i = 1; i <= r2; i++) {
      long r2Pair = (long) Math.floor(Math.sqrt(1.0 * r2 * r2 - 1.0 * i * i));
      long r1Pair = (long) Math.ceil(Math.sqrt(1.0 * r1 * r1 - 1.0 * i * i)); // 음수의 제곱근은 0
      answer += r2Pair - r1Pair + 1;
    }
    return answer * 4;
  }

}

