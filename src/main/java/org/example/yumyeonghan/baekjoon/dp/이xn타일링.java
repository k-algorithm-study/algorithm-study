package org.example.yumyeonghan.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/11726
public class 이xn타일링 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    // 2 X N 에서 N 값에 따라 만들 수 있는 타일 수를 저장할 dp 테이블 생성
    int[] dp = new int[n + 1];
    dp[0] = 1; // dp[2]를 만들기 위해 끼워 맞춤
    dp[1] = 1; // 2 X 1 에서 만들 수 있는 유형은 1
    // 2 X 2 에서 만들 수 있는 유형은 2이지만, n 값이 1일 때 dp[2]가 될 수 없다.
    for (int i = 2; i <= n; i++) {
      dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
    }
    System.out.println(dp[n]);
  }

}
