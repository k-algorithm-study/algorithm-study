package org.example.kw99j10.baekjoon.dp;

import java.util.Scanner;

/**
 * 1로 만들기 - Silver III
 */
public class DP01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] dp = new int[1000001];
        dp[0] = 0;
        dp[1] = 0;

        //n까지 다이나믹 프로그래밍 계산
        for (int i = 2; i <= n; i++) {

            //1을 더함(1을 뺌)
            dp[i] = dp[i - 1] + 1;

            //3으로 나누어 떨어지면, 3으로 나눔
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }

            //2로 나누어 떨어지면, 2로 나눔
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
        }
        System.out.println(dp[n]);
    }
}
