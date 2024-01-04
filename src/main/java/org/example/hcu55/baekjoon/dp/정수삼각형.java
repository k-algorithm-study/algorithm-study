package org.example.hcu55.baekjoon.dp;

import java.util.Scanner;

// 정수 삼각형, 실버 I
public class 정수삼각형 {
    static int[][] arr;
    static Integer[][] dp;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n][n];
        dp = new Integer[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = arr[n - 1][i];
        }
        System.out.println(find(0, 0));
    }

    static int find(int depth, int idx) {
        if (depth == n - 1) return dp[depth][idx];   // 마지막 행일 경우 현재 위치의 dp값 반환

        if (dp[depth][idx] == null) {               // 탐색하지 않았던 값일 경우 다음 행의 양쪽 값 비교
            dp[depth][idx] = Math.max(find(depth + 1, idx), find(depth + 1, idx + 1)) + arr[depth][idx];
        }
        return dp[depth][idx];
    }
}
