package org.example.kw99j10.baekjoon.dp;

import java.util.Scanner;

/**
 *  2xn 타일링 - Silver III
 */
public class DP04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[] dp = new long[1001]; //n의 범위

        dp[1] = 1;
        dp[2] = 2;

        //3번째 항부터 일정한 규칙
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] % 10007 + dp[i - 2] % 10007;
        }
        System.out.println(dp[n] % 10007);
    }
}
