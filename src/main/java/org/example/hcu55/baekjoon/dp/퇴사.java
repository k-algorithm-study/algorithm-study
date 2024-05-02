package org.example.hcu55.baekjoon.dp;

import java.util.*;

// 퇴사, 실버 III
public class 퇴사 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] T = new int[N];       // 상담 소요 기간
        int[] P = new int[N];       //금액


        for (int i = 0; i < N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        int[] dp = new int[N + 1];

        for (int i = 0; i < N; i++) {

            if (i + T[i] <= N) {       // 날짜 N 범위에 벗어나지 않으면
                dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
            }

            // 해당 날짜에 일 불가능 할 때 이전까지 값 넣어주기 위해
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);    // 다음 dp = 현재 누적값 vs 다음 누적값

        }
        System.out.println(dp[N]);
    }
}