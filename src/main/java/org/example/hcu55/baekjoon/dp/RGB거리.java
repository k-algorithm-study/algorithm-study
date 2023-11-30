package org.example.hcu55.baekjoon.dp;

import java.util.Scanner;

// RGB거리, 실버 I
public class RGB거리 {
    final static int Red = 0;
    final static int Green = 1;
    final static int Blue = 2;
    static int[][] house;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        house = new int[N][3];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {       // 빨강 초록 파랑 집 정보 입력 받기
            house[i][Red] = sc.nextInt();
            house[i][Green] = sc.nextInt();
            house[i][Blue] = sc.nextInt();
        }

        dp[0][Red] = house[0][Red];         // 초기 값은 각 색상의 첫번째 값으로 초기화
        dp[0][Green] = house[0][Green];
        dp[0][Blue] = house[0][Blue];

        System.out.print(Math.min(paintHouse(N - 1, Red), Math.min(paintHouse(N - 1, Green), paintHouse(N - 1, Blue))));
    }

    static int paintHouse(int n, int color) {
        if (dp[n][color] == 0) {
            if (color == Red)
                dp[n][Red] = Math.min(paintHouse(n - 1, Green), paintHouse(n - 1, Blue)) + house[n][Red];
            if (color == Green)
                dp[n][Green] = Math.min(paintHouse(n - 1, Red), paintHouse(n - 1, Blue)) + house[n][Green];
            if (color == Blue)
                dp[n][Blue] = Math.min(paintHouse(n - 1, Red), paintHouse(n - 1, Green)) + house[n][Blue];
        }
        return dp[n][color];
    }
}
