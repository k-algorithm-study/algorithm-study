package org.example.yumyeonghan.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1003
public class 피보나치함수 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    StringBuilder stringBuilder = new StringBuilder();
    int[][] dp = new int[41][2];

    // 초기값
    dp[0][0] = 1;
    dp[0][1] = 0;
    dp[1][0] = 0;
    dp[1][1] = 1;

    // ex) 0 => (1, 0),  1 => (0, 1), 2 => (1, 1), 3 => (1, 2)
    // 즉, dp[3][0] = dp[1][0] + dp[2][0], dp[3][1] = dp[1][1] + dp[2][1]
    for (int i = 2; i <= 40; i++) {
      dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
      dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
    }
    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());
      if (n == 0) {
        stringBuilder.append("1 0").append("\n");
        continue;
      }
      if (n == 1) {
        stringBuilder.append("0 1").append("\n");
        continue;
      }
      stringBuilder.append(dp[n][0] + " " + dp[n][1]).append("\n");
    }
    System.out.println(stringBuilder);
  }

}
