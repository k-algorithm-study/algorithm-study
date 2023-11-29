package org.example.hcu55.baekjoon.dp;

import java.util.Scanner;

// 계단 오르기, 실버 III
public class 계단오르기 {
    static Integer dp[];
    static int arr[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        dp = new Integer[N + 1];
        arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        dp[0] = arr[0];     // 초기화
        dp[1] = arr[1];

        if (N >= 2) {       // 계단이 1칸일 때가 있기에 N이 2 이상인 경우 작동
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(topDown(N));
    }

    static int topDown(int N) {
        if (dp[N] == null) {       // 아직 오르지 않은 계단인 경우
            dp[N] = Math.max(topDown(N - 2), topDown(N - 3) + arr[N - 1]) + arr[N];
        }
        return dp[N];
    }
}
