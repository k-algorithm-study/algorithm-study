package org.example.kw99j10.baekjoon.dp;

import java.util.Scanner;

/**
 * 정수 삼각형 - Silver I
 */
public class DP08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] triangle = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                triangle[i][j] = sc.nextInt(); //정수 삼각형을 입력 받음
            }
        }

        int[][] dp = new int[n + 1][n + 1]; //각 경로에 따른 최대 합을 구함

        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                //그림 상으로 왼쪽 또는 오른쪽 대각선에서 선택
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(max);
    }
}
