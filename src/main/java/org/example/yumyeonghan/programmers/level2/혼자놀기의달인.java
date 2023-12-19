package org.example.yumyeonghan.programmers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/131130
public class 혼자놀기의달인 {

  private static int count;
  private static boolean[] isVisited;

  public int solution(int[] cards) {
    isVisited = new boolean[cards.length + 1];
    List<Integer> list = new ArrayList<>();
    for (int i = 1; i <= cards.length; i++) {
      if (!isVisited[i]) {
        count = 1;
        isVisited[i] = true;
        dfs(cards, cards[i - 1]);
        list.add(count);
      }
    }
    if (list.size() == 1) {
      return 0;
    }
    Collections.sort(list, Collections.reverseOrder());
    return list.get(0) * list.get(1);
  }

  private void dfs(int[] cards, int card) {
    if (!isVisited[card]) {
      isVisited[card] = true;
      count += 1;
      dfs(cards, cards[card - 1]);
    }
  }

}
