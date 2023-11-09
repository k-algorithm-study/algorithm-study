package org.example.kw99j10.baekjoon.dp;

import java.util.Scanner;

/**
 * 피보나치 함수 - Silver III
 */
public class DP03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); //테스트 케이스의 수

        int[] dp_zero = new int[41]; //0이 출력되는 횟수 dp 배열
        int[] dp_one = new int[41]; //1이 출력되는 횟수 dp 배열

        //초기값 초기화
        dp_zero[0] = dp_one[1] = 1;
        dp_zero[1] = dp_one[0] = 0;


        for (int i = 2; i <= 40; i++) {
            dp_zero[i] = dp_zero[i - 1] + dp_zero[i - 2];
            dp_one[i] = dp_one[i - 1] + dp_one[i - 2];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(); //테스트 케이스 -> 0 출력 횟수와 1 출력 횟수를 출력
            sb.append(dp_zero[n]).append(" ").append(dp_one[n]).append("\n");
        }
        System.out.print(sb);
    }
}
