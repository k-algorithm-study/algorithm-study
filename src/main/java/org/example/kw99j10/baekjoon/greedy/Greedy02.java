package org.example.kw99j10.baekjoon.greedy;

import java.util.Scanner;

/**
 * 동전 0 - Silver IV
 */
public class Greedy02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //N개의 줄
        int K = sc.nextInt(); //K원

        int[] a = new int[N];//N종류의 동전을 담을 배열

        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }

        int min = 0; //필요한 최소 동전 개수

        int count = a.length - 1; //오름차순이므로 배열의 마지막 값부터 비교

        while (K != 0) {
            min += K / a[count];
            K = K % a[count];
            count -= 1;
        }
        System.out.println(min);
    }
}
