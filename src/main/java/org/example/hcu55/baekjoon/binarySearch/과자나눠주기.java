package org.example.hcu55.baekjoon.binarySearch;

import java.util.*;

// 과자 나눠주기, 실버 II
public class 과자나눠주기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();       // 조카 수
        int N = sc.nextInt();       // 과자 수
        int[] arr = new int[N];
        int max = 0;                // 길이 최대값

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }

        int left = 1;
        int right = max;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;                      // mid 로 나눴을 때 과자 총 개수

            for (int i = 0; i < arr.length; i++) {
                cnt += arr[i] / mid;          // 현재 mid값으로 과자의 길이를 나눈 나온 과자 개수
            }

            if (cnt >= M) {                   // 나눈 갯수가 조카 수보다 같거나 많을 경우
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}
