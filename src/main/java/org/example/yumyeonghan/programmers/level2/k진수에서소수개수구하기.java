package org.example.yumyeonghan.programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/92335
public class k진수에서소수개수구하기 {

  public int solution(int n, int k) {
    int answer = 0;

    // n을 k진수로 나타내기
    String num = Integer.toString(n, k);

    // 소수 구하기
    for (String s : num.split("0")) {
      if (!s.equals("") && isPrime(s)) {
        answer++;
      }
    }
    return answer;
  }

  private boolean isPrime(String s) {
    long num = Long.parseLong(s);
    if (num == 1) {
      return false;
    }
    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }

}
