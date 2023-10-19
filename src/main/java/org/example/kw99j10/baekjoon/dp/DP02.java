package org.example.kw99j10.baekjoon.dp;

import java.util.Scanner;

/**
 * 1,2,3 더하기  - Silver III
 */
public class DP02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); //테스트 케이스의 수

        /**
         * 1~3까지의 정수를 1,2,3의 합으로 나타내는 방법 가짓 수
         * n:1 -> 1, n:2 -> 2, n:3 -> 4
         */

        int[] arr = new int[11]; //n의 조건: n<=11
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(); //주어진 정수

            //다이내믹 프로그래밍 구현: 현재 항은 이전 3항의 합과 같음
            for (int j = 4; j <= n; j++) {
                arr[j] = arr[j - 1] + arr[j - 2] + arr[j - 3];
            }
            System.out.println(arr[n]);
        }
    }
}
