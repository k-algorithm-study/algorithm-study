package org.example.yumyeonghan.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2579
public class 계단오르기 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] stairs = new int[301];
    for (int i = 1; i <= n; i++) {
      stairs[i] = Integer.parseInt(br.readLine());
    }
    int[] dp = new int[301];
    dp[1] = stairs[1];
    dp[2] = stairs[1] + stairs[2];
    dp[3] = Math.max(stairs[1] + stairs[3], stairs[2] + stairs[3]);

    for (int i = 4; i <= n; i++) {
      // 연속된 3개의 계단을 밟으면 안되기 때문에 점화식을 다음과 같이 세움
      dp[i] = Math.max(dp[i - 3] + stairs[i - 1] + stairs[i], dp[i - 2] + stairs[i]);
    }
    System.out.println(dp[n]);
  }

}
