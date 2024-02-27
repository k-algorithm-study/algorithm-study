package org.example.hcu55.baekjoon.test;

import java.util.*;

public class RGB거리 {
    static int[][] cost;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        cost = new int[N][3];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            cost[i][0] = sc.nextInt();
            cost[i][1] = sc.nextInt();
            cost[i][2] = sc.nextInt();
        }

        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        System.out.println(Math.min(paintHouse(N - 1, 0), Math.min(paintHouse(N - 1, 1), paintHouse(N - 1, 2))));
    }

    static int paintHouse(int n, int color) {
        if (dp[n][color] == 0) {
            if (color == 0)
                dp[n][0] = Math.min(paintHouse(n - 1, 1), paintHouse(n - 1, 2)) + cost[n][0];
            if (color == 1)
                dp[n][1] = Math.min(paintHouse(n - 1, 0), paintHouse(n - 1, 2)) + cost[n][1];
            if (color == 2)
                dp[n][2] = Math.min(paintHouse(n - 1, 0), paintHouse(n - 1, 1)) + cost[n][2];
        }
        return dp[n][color];
    }
}
