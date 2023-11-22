package org.example.yumyeonghan.baekjoon.sort;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1946
public class 신입사원 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    // 배열의 인덱스에 서류 순위, 값에 면접 순위 초기화
    for (int i = 0; i < n; i++) {
      int m = scanner.nextInt();
      int count = 1;
      int tmp[] = new int[m + 1];
      for (int j = 0; j < m; j++) {
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        tmp[a] = b;
      }

      // 다른 모든 지원자와 비교했을 때 하나라도 떨어지는게 있으면 안됨
      // 따라서, 1등 서류자의 면접 순위를 다음 사람들과 차례대로 비교하여 면접 순위가 더 높은 사람을 카운팅
      // 이떄 해당 사람의 면접 순서로 기준을 변경
      /**
       * 2번째 예시
       * 1, 4 선발
       * 2, 5
       * 3, 6
       * 4, 2 선발
       * 5, 7
       * 6, 1 선발
       * 7, 3
       */
      int base = tmp[1];
      for (int j = 2; j <= m; j++) {
        if (tmp[j] < base) {
          base = tmp[j];
          count++;
        }
      }
      System.out.println(count);
    }
  }

}
