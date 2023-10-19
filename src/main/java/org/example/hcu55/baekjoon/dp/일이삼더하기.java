package org.example.hcu55.baekjoon.dp;

import java.util.Scanner;

// 1,2,3 더하기, 실버 III
public class 일이삼더하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dp[] = new int[11];

        int t = sc.nextInt();

        dp[1] = 1;  //초기 값 초기화
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < 11; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];  // 점화식
        }

        for (int j = 0; j < t; j++) {
            int n = sc.nextInt();

            System.out.println(dp[n]);
        }
    }
}
