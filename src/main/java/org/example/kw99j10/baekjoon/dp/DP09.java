package org.example.kw99j10.baekjoon.dp;

import java.util.Scanner;
/**
 * 연속합 - Silver II
 */
public class DP09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[n];
        dp[0] = arr[0];

        int max = dp[0]; //초기값 세팅

        //연속된 몇 개 수의 합 중 가장 큰 합
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
