package org.example.yumyeonghan.programmers.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/155652
public class 둘만의암호 {

  public String solution(String s, String skip, int index) {
    String answer = "";
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      for (int j = 0; j < index; j++) {
        c += 1;
        if (c > 'z') {
          c = 'a';
        }
        if (skip.contains(String.valueOf(c))) {
          j--; // 인덱스 한번 더타기 위해
        }
      }
      answer += String.valueOf(c);
    }
    return answer;
  }

}
