package org.example.hcu55.baekjoon.binarySearch;

import java.util.Arrays;
import java.util.Scanner;

// 숫자 카드 2, 실버 IV
public class 숫자카드2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);	// 이분 탐색을 하기 위해서 정렬.

        int M = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++) {
            int number_card = sc.nextInt();
            sb.append(upper(arr, number_card) - lower(arr, number_card)).append(' ');
        }
        System.out.println(sb);
    }

    public static int lower(int[] arr, int number) {
        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (number <= arr[mid])
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }

    public static int upper(int[] arr, int number) {
        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (number < arr[mid])      // number값이 mid 위치의 값보다 작을 경우
                high = mid;
            else                        // 중복원소의 경우 else에서 처리된다.
                low = mid + 1;
        }
        return low;
    }
}