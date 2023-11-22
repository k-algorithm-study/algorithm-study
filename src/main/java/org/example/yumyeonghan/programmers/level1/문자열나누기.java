package org.example.yumyeonghan.programmers.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/140108
public class 문자열나누기 {

  public int solution(String s) {
    int answer = 0;
    int count = 1;
    char x = s.charAt(0);

    for (int i = 1; i < s.length(); i++) {
      if (count == 0) {
        answer++;
        x = s.charAt(i);
      }
      if (x == s.charAt(i)) {
        count++;
      } else {
        count--;
      }
    }
    return answer + 1; // 마지막 계산 못한거 + 1
  }

}
