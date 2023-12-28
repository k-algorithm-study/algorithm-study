package org.example.yumyeonghan.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11053
public class 가장긴증가하는부분수열 {

  public static void main(String[] args) throws IOException {
    int answer = 1; // 가장 긴 부분 수열의 길이는 최소 1
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bufferedReader.readLine());
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    int arr[] = new int[n + 1];
    int dp[] = new int[n + 1]; // n번째 수열일 때 가장 긴 증가하는 부분 수열의 길이
    for (int i = 1; i <= n; i++) {
      arr[i] = Integer.parseInt(stringTokenizer.nextToken());
    }

    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      dp[i] = 1;
      for (int j = 1; j < i; j++) {
        if (arr[i] > arr[j] && dp[i] <= dp[j]) {
          dp[i] = dp[j] + 1;
        }
      }
      answer = Math.max(answer, dp[i]);
    }
    System.out.println(answer);
  }

}
