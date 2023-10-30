package org.example.yumyeonghan.programmers.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/159994
public class 카드뭉치 {

  public String solution(String[] cards1, String[] cards2, String[] goal) {
    int card1Idx = 0;
    int card2Idx = 0;
    for (int i = 0; i < goal.length; i++) {
      if (card1Idx < cards1.length && goal[i].equals(cards1[card1Idx])) {
        card1Idx++;
      } else if (card2Idx < cards2.length && goal[i].equals(cards2[card2Idx])) {
        card2Idx++;
      } else {
        return "No";
      }
    }
    return "Yes";
  }

}
