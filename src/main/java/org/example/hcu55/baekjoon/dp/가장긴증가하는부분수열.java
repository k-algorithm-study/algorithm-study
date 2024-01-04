package org.example.hcu55.baekjoon.dp;

import java.util.Scanner;

// 가장 긴 증가하는 부분 수열, 실버 II
public class 가장긴증가하는부분수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] listA = new int[N];
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            listA[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (listA[j] < listA[i] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int max = 0;
        for (int len : dp) {
            max = Math.max(max, len);
        }
        System.out.println(max);
    }
}
