package org.example.hcu55.baekjoon.test;

import java.util.*;

public class 계단오르기 {

    static Integer[] dp;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr = new int[n + 1];
        dp = new Integer[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        dp[0] = arr[0];
        dp[1] = arr[1];

        if (n >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(topdown(n));
    }

    static int topdown(int n) {
        if (dp[n] == null) {
            dp[n] = Math.max(topdown(n - 2), topdown(n - 3) + arr[n - 1]) + arr[n];
        }
        return dp[n];
    }
}
