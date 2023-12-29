package org.example.kw99j10.baekjoon.dp;

import java.util.Scanner;

/**
 * 가장 긴 증가하는 부분 수열 - Silver II
 */
public class DP07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        int[] tmp = new int[n]; //증가하는 부분 수열을 나타낼 배열

        int max = 0; //가장 긴 증가하는 부분 수열의 길이

        for (int i = 0; i < n; i++) {

            tmp[i] = 1; //기본 길이: 1

            //배열이 증가하는 지 여부를 검사
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j] && tmp[j] + 1 > tmp[i]) {
                    tmp[i] = tmp[j] + 1; //증가한다면 길이 1씩 증가
                }
            }
            max = Math.max(max, tmp[i]);
        }
        System.out.println(max);
    }
}
