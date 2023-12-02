package org.example.kw99j10.baekjoon.dp;

import java.util.Scanner;

/**
 *  계단 오르기 - Silver III
 */
public class DP06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //계단의 개수

        int[] arr = new int[n]; //계단에 적힌 점수
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        //계단의 개수가 1개라면 해당 점수를 리턴
        if (n == 1) {
            System.out.println(arr[0]);
            return;
        }

        //계단의 개수가 2개라면 두 계단 점수의 합을 리턴
        else if (n == 2) {
            System.out.println(arr[0] + arr[1]);
            return;
        }

        //계단을 오르는 경우의 수 - 현재 계단을 n이라 할 때
        //1. n-3, n-1을 밟고 감
        //2. n-2를 밟고 감

        int[] dp = new int[n]; //총 점수의 최댓값을 구하는 배열
        dp[0] = arr[0];
        dp[1] = dp[0] + arr[1];
        dp[2] = Math.max(dp[0], arr[1]) + arr[2];

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 2], arr[i - 1] + dp[i - 3]) + arr[i];
        }
        System.out.println(dp[n - 1]);
    }
}
