package org.example.yumyeonghan.programmers.level1;

import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/176963
public class 추억점수 {

  private static Map<String, Integer> nameInfo = new HashMap<>();

  public int[] solution(String[] name, int[] yearning, String[][] photos) {
    for (int i = 0; i < name.length; i++) {
      nameInfo.put(name[i], Integer.valueOf(yearning[i]));
    }

    int[] answer = new int[photos.length];
    int answerIndex = 0;

    for (String[] photo : photos) {
      int count = 0;
      for (String person : photo) {
        if (nameInfo.containsKey(person)) {
          count += nameInfo.get(person);
        }
      }
      answer[answerIndex] = count;
      answerIndex += 1;
    }
    return answer;
  }

}
