package org.example.kw99j10.baekjoon.dp;

import java.util.Scanner;

/**
 * 포도주 시식 - Silver I
 */
public class DP12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] grape = new int[10001];
        for (int i = 1; i <= n; i++) {
            grape[i] = sc.nextInt();
        }

        int[] dp = new int[10001];
        dp[1] = grape[1];
        dp[2] = grape[2] + dp[1];

        for (int i = 3; i <= n; i++) {
            //경우의 수 1: 이전 잔까지의 누적 포도주가 현재 잔의 포도주보다 큰 경우
            //2: 3번째 전 잔 + 이전 잔 + 현재 잔
            //3: 2번째 전 까지의 누적 잔 + 현재 잔
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 3] + grape[i - 1], dp[i - 2]) + grape[i]);
        }
        System.out.println(dp[n]);
    }
}
