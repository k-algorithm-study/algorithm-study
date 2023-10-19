package org.example.yumyeonghan.baekjoon.dp;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1463
public class 일로만들기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int dp[] = new int[n + 1]; //dp[10]: 10을 1로 만들기 위한 연산의 최소 횟수 정보

        // 0과 1 숫자는 1로 만들기 위한 연산의 최소 횟수 정보가 0이므로 2부터 시작
        // dp(bottom-up) 알고리즘 사용
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1; // 1. 1을 뺀다.

            // 2. i가 2로 나누어 떨어지면, 2로 나눈다.
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            // 3. i가 3으로 나누어 떨어지면, 3으로 나눈다.
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        System.out.println(dp[n]);
    }

}
