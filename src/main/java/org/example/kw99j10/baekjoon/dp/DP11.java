package org.example.kw99j10.baekjoon.dp;

import java.util.Scanner;

/**
 * 2xn 타일링 2 - Silver III
 */
public class DP11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
        }
        System.out.println(dp[n]);
    }
}
