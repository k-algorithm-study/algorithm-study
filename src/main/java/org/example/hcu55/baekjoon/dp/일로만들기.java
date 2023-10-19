package org.example.hcu55.baekjoon.dp;

import java.util.Scanner;

// 1로 만들기, 실버 III
public class 일로만들기 {

    static Integer[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        dp = new Integer[n + 1];
        dp[0] = dp[1] = 0;

        System.out.println(recur(n));
    }

    static int recur(int n) {

        if (dp[n] == null) {
            if (n % 6 == 0) {   // 6으로 나눠지는 경우 = 3가지 중 낮은거
                dp[n] = Math.min(recur(n - 1), Math.min(recur(n / 3), recur(n / 2))) + 1;
            }
            else if (n % 3 == 0) {  // 3으로만 나눠지는 경우 = 2가지 중 낮은거
                dp[n] = Math.min(recur(n / 3), recur(n - 1)) + 1;
            }
            else if (n % 2 == 0) {  // 2로만 나눠지는 경우 = 2가지 중 낮은거
                dp[n] = Math.min(recur(n / 2), recur(n - 1)) + 1;
            }
            else {  // 2와 3으로 나누어지지 않는 경우 = 1을 빼는 경우
                dp[n] = recur(n - 1) + 1;
            }
        }
        return dp[n];
    }
}
