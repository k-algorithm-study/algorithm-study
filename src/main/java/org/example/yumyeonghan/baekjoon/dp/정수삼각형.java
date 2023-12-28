package org.example.yumyeonghan.baekjoon.dp;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1932
public class 정수삼각형 {

  public static void main(String[] args) {

    // init arr && dp
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int arr[][] = new int[n][n];
    int dp[][] = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= i; j++) {
        arr[i][j] = sc.nextInt();
      }
    }

    // start dp
    dp[0][0] = arr[0][0];
    for (int floor = 1; floor < n; floor++) {
      for (int idx = 0; idx <= floor; idx++) {
        if (idx == 0) {
          dp[floor][idx] = dp[floor - 1][idx] + arr[floor][idx];
        } else if (idx == floor) {
          dp[floor][idx] = dp[floor - 1][idx - 1] + arr[floor][idx];
        } else {
          dp[floor][idx] = Math.max(dp[floor - 1][idx - 1], dp[floor - 1][idx]) + arr[floor][idx];
        }
      }
    }

    // output answer
    int answer = 0;
    for (int i = 0; i < n; i++) {
      answer = Math.max(answer, dp[n - 1][i]);
    }
    System.out.println(answer);
  }

}
