package org.example.hcu55.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2 x n 타일링, 실버 III
public class 이xn타일링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];   // n의 최대 범위
        dp[1] = 1;      // n = 1일때, 채우는 방법 개수
        dp[2] = 2;      // n = 2일때, 채우는 방법 개수

        for (int i = 3; i <= n; i++) {      // 3부터 시작
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;    // 점화식
        }
        System.out.println(dp[n]);
    }
}
