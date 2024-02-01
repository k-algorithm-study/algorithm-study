package org.example.hcu55.baekjoon.dp;

import java.util.Scanner;

// 파도반 수열, 실버 III
public class 파도반수열 {
    public static long[] arr = new long[101];       // 파도반 수열 저장할 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 2;
        arr[4] = 2;

        int testCase = sc.nextInt();

        for (int i = 0; i < testCase; i++) {
            int N = sc.nextInt();

            for (int j = 5; j < N; j++) {
                if (arr[j] == 0) {
                    arr[j] = arr[j - 1] + arr[j - 5];   // 파도반 수열의 규칙
                }
            }
            System.out.println(arr[N - 1]);
        }
    }
}
