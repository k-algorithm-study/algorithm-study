package org.example.kw99j10.baekjoon.dp;

import java.util.Scanner;

/**
 *  쉬운 계단 수 - Silver I
 */
public class DP13 {
    static final int V = 1000000000; //상수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[][] dp = new long[n + 1][10];

        //1자리 수
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < 10; j++) {

                //계단 수 형태: dp[i][j]=dp[i-1][j-1]+dp[i-1][j+1]
                if (j == 0) {
                    dp[i][0] = dp[i - 1][1] % V; //0일때는 1인 경우의 계단 수만
                } else if (j == 9) {
                    dp[i][9] = dp[i - 1][8] % V; //9일때는 8인 경우의 계단 수만
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % V;
                }
            }
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[n][i] % V;
        }
        System.out.println(sum % V);
    }
}
