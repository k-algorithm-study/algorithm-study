package org.example.kw99j10.baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 로프 - Silver IV
 */
public class Greedy05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //주어진 로프의 개수

        int[] arr = new int[N]; //로프를 담을 배열
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        //"각" 로프가 버틸 수 있는 최대 중량을 구하기 위해 배열 정렬
        Arrays.sort(arr);

        //최소 중량 로프부터 (w/k)를 계산
        int maximum = 0;
        for (int i = 0; i < arr.length; i++) {
            maximum = Math.max(maximum, arr[i] * (N - i));
        }
        System.out.println(maximum);
    }
}
