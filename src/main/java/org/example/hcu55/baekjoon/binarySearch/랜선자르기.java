package org.example.hcu55.baekjoon.binarySearch;

import java.util.Scanner;

// 랜선 자르기, 실버 II
public class 랜선자르기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();       // 가지고 있는 랜선 수
        int N = sc.nextInt();       // 필요한 랜선 수

        int[] arr = new int[K];
        long max = 0;               // 랜선 최대 값 구하기

        for (int i = 0; i < K; i++) {
            arr[i] = sc.nextInt();
            if (max < arr[i]) {
                max = arr[i];       // max 최대값으로 갱신
            }
        }
        max++;
        long min = 0;
        long mid = 0;

        while (min < max) {
            mid = (max + min) / 2;
            long count = 0;

            for (int i = 0; i < arr.length; i++) {
                count += (arr[i] / mid);      // mid로 잘라서 몇개인지 확인한다.
            }

            if (count < N) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }
}
