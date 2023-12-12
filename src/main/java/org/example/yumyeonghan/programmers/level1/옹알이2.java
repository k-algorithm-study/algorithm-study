package org.example.yumyeonghan.programmers.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/133499
public class 옹알이2 {

  public int solution(String[] babbling) {
    int answer = 0;
    String[] str = {"aya", "ye", "woo", "ma"};
    String[] repeatedStr = {"ayaaya", "yeye", "woowoo", "mama"};
    for (int i = 0; i < babbling.length; i++) {
      for (int j = 0; j < str.length; j++) {
        babbling[i] = babbling[i]
            .replaceAll(repeatedStr[j], "1")
            .replaceAll(str[j], " "); // " "대신 ""로 대체하면, 남은 양옆의 글자들이 붙어서 엉뚱한 문자가 생김
      }
      if (babbling[i].trim().isEmpty()) {
        answer++;
      }
    }
    return answer;
  }

}
