package org.example.kw99j10.baekjoon.search.binary;

import java.util.Scanner;

/**
 * 기타 레슨 - Silver I
 */
public class Binary07 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];

        int max = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }

        int start = max;
        int end = sum;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;

            int count = 1;
            int tmpSum = 0;

            for (int i = 0; i < n; i++) {
                tmpSum += arr[i];

                if (tmpSum > mid) {
                    count += 1;
                    tmpSum = arr[i];
                }
            }

            if (count > m) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        System.out.println(start);
    }
}
