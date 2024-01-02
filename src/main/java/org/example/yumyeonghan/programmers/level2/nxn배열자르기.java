package org.example.yumyeonghan.programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/87390
public class nxn배열자르기 {

  /**
   * [2차원 배열]
   * 1 2 3
   * 2 2 3
   * 3 3 3
   * 규칙 : 2차원 배열의 규칙을 보면, 각 좌표의 값은 Math.max(행, 열)인 것을 알 수 있다.
   * [1차원 배열]
   * 123 223 333
   * 규칙 : 각 값의 좌표는 (index / n + 1, index % n + 1)인 것을 알 수 있다.
   */

  public int[] solution(int n, long left, long right) {
    int[] answer = new int[(int) (right - left + 1)];
    int index = 0;
    for (long i = left; i <= right; i++) {
      long row = i / n + 1;
      long col = i % n + 1;
      answer[index++] = (int) Math.max(row, col);
    }
    return answer;
  }

}
