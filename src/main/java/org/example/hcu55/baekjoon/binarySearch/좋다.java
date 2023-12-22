package org.example.hcu55.baekjoon.binarySearch;

import java.util.Arrays;
import java.util.Scanner;

// 좋다, 골드 IV
public class 좋다 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] num = new int[N];

        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }
        Arrays.sort(num);

        int count = 0;

        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N - 1;

            while (true) {
                if (i == left) {
                    left++;
                } else if (i == right) {
                    right--;
                }

                if (left >= right) {
                    break;
                }

                if (num[left] + num[right] > num[i]) {
                    right--;
                } else if (num[left] + num[right] < num[i]) {
                    left++;
                } else {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
