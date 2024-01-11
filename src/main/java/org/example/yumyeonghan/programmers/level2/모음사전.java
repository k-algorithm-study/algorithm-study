package org.example.yumyeonghan.programmers.level2;

import java.util.ArrayList;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/84512
public class 모음사전 {

  private List<String> allStrings = new ArrayList<>();
  private String[] words = {"A", "E", "I", "O", "U"};

  public int solution(String word) {
    int answer = 0;
    dfs("", 0);
    for (int i = 1; i < allStrings.size(); i++) {
      if (allStrings.get(i).equals(word)) {
        answer = i;
      }
    }
    return answer;
  }

  private void dfs(String s, int depth) {
    allStrings.add(s);
    if (depth == 5) {
      return;
    }
    for (int i = 0; i < words.length; i++) {
      dfs(s + words[i], depth + 1);
    }
  }

}
