package org.example.hcu55.baekjoon.dp;

import java.util.Scanner;

// 연속합, 실버 II
public class 연속합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[N];      // 이전까지 합과 현재 위치의 값을 비교해서 저장할 배열
        dp[0] = arr[0];
        int max = arr[0];       // max값 변수

        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);   // (이전까지 값과 + 현재 arr값) vs 현재 arr값 중 큰 것을 dp에 저장
            max = Math.max(max, dp[i]);     // 최댓값 갱신
        }
        System.out.println(max);
    }
}
