package org.example.yumyeonghan.programmers.level1;

import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/118666
public class 성격유형검사하기 {

  public String solution(String[] survey, int[] choices) {
    String answer = "";

    // init map (각 유형과 점수를 저장)
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < survey.length; i++) {
      String[] str = survey[i].split("");
      int score = choices[i];
      if (score >= 1 && score <= 3) {
        map.put(str[0], map.getOrDefault(str[0], 0) + 4 - score);
      } else if (score >= 5 && score <= 7) {
        map.put(str[1], map.getOrDefault(str[1], 0) + score - 4);
      }
    }

    // survey의 원소는 "RT", "TR", "FC", "CF", "MJ", "JM", "AN", "NA" 중 하나
    // R, C, J, A가 사전순으로 더 높기 때문에, 점수가 크거나 같으면 뽑고, 그렇지 않으면 T, F, M, N을 뽑음
    answer += map.getOrDefault("R", 0) >= map.getOrDefault("T", 0) ? "R" : "T";
    answer += map.getOrDefault("C", 0) >= map.getOrDefault("F", 0) ? "C" : "F";
    answer += map.getOrDefault("J", 0) >= map.getOrDefault("M", 0) ? "J" : "M";
    answer += map.getOrDefault("A", 0) >= map.getOrDefault("N", 0) ? "A" : "N";
    return answer;
  }

}
