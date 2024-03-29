package org.example.hcu55.baekjoon.test;

import java.util.*;

public class 일이삼더하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dp[] = new int[11];

        int testCase = sc.nextInt();

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < 11; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }

        for (int i = 0; i < testCase; i++) {
            int n = sc.nextInt();

            System.out.println(dp[n]);
        }
    }
}
