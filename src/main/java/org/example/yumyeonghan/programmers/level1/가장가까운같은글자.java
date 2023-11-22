package org.example.yumyeonghan.programmers.level1;


// https://school.programmers.co.kr/learn/courses/30/lessons/142086
public class 가장가까운같은글자 {

  public int[] solution(String s) {
    int[] answer = new int[s.length()];
    for (int i = 0; i < answer.length; i++) {
      // 현재 위치보다 앞을 순회하며,
      for (int j = i; j >= 0; j--) {
        // 가장 처음 같은 글자를 찾으면 그것이 가장 가까운 수이기 때문에 answer[i] == 0
        if (s.charAt(i) == s.charAt(j) && answer[i] == 0) {
          answer[i] = i - j;
        }
      }
      if (answer[i] == 0) {
        answer[i] = -1;
      }
    }
    return answer;
  }

}
