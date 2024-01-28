package org.example.kw99j10.baekjoon.dp;

import java.util.Scanner;

/**
 * 파도반 수열 - Silver III
 */
public class DP10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); //테스트 케이스 개수

        //int 형일 경우 오버플로우 발생
        long[] dp = new long[101]; //파도반 수열
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        for (int i = 5; i <= 100; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] - dp[i - 4];
        }

        StringBuilder sb = new StringBuilder();
        //해당 수열의 값을 출력
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            sb.append(dp[n]).append("\n");
        }
        System.out.print(sb);
    }
}
