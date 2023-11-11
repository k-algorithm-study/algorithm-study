package org.example.yumyeonghan.programmers.level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/150370
public class 개인정보수집유효기간 {

  public int[] solution(String today, String[] terms, String[] privacies) {
    List<Integer> answer = new ArrayList<>();
    Map<String, Integer> termMap = new HashMap<>();
    for (String term : terms) {
      String[] tmp = term.split(" ");
      termMap.put(tmp[0], Integer.valueOf(tmp[1]));
    }
    int currentDate = getDate(today);
    for (int i = 0; i < privacies.length; i++) {
      String[] privacy = privacies[i].split(" ");
      // 유효기간이 현재 날짜보다 전에 끝나버리는 경우 정답에 추가
      if (getDate(privacy[0]) + (termMap.get(privacy[1]) * 28) <= currentDate) {
        answer.add(i + 1);
      }
    }
    return answer.stream().mapToInt(i -> i).toArray();
  }

  private int getDate(String today) {
    String[] date = today.split("\\.");
    Integer year = Integer.valueOf(date[0]);
    Integer month = Integer.valueOf(date[1]);
    Integer day = Integer.valueOf(date[2]);
    return (year * 12 * 28) + (month * 28) + day;
  }

}
