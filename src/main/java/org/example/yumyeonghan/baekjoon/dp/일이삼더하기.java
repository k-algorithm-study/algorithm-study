package org.example.yumyeonghan.baekjoon.dp;

import java.util.Scanner;

// https://www.acmicpc.net/problem/9095
public class 일이삼더하기 {

  static private int dp[] = new int[11];

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int testcase = scanner.nextInt();
    for (int i = 0; i < testcase; i++) {
      int n = scanner.nextInt();
      dp[1] = 1; // 1
      dp[2] = 2; // 1 + 1, 2
      dp[3] = 4; // 1 + 1 + 1, 1 + 2, 2 + 1, 3
      for (int j = 4; j <= n; j++) {
        dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
      }
      System.out.println(dp[n]);
    }
  }

}
