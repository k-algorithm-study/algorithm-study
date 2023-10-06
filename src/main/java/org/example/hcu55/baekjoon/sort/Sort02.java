package org.example.hcu55.baekjoon.sort;

import java.util.Arrays;
import java.util.Scanner;

//ATM, 실버4
public class Sort02 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);     // 정렬

        int before = 0;     // 이전 사람까지 누적 합
        int sum = 0;        // 모든 사람 대기시간 합

        for (int i = 0; i < N; i++) {
            sum += before + arr[i];
            before += arr[i];
        }
        System.out.println(sum);
    }
}
