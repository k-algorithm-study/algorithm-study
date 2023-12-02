package org.example.kw99j10.baekjoon.dp;

import java.util.Scanner;

/**
 *  RGB 거리 - Silver I
 */
public class DP05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //집의 수

        int[][] home = new int[n][3]; //집을 칠하는 비용

        for (int i = 0; i < n; i++) {
            home[i][0] = sc.nextInt(); //빨강으로 칠하는 비용
            home[i][1] = sc.nextInt(); //초록으로 칠하는 비용
            home[i][2] = sc.nextInt(); //파랑으로 칠하는 비용
        }

        int[][] dp = new int[n][3]; //모든 집을 칠하는 비용의 최솟값을 출력할 배열

        dp[0][0] = home[0][0];
        dp[0][1] = home[0][1];
        dp[0][2] = home[0][2];

        //N번 집의 색 != N-1번 집의 색
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + home[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + home[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + home[i][2];
        }

        int min=Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
        System.out.println(min);
    }
}
