package org.example.hcu55.baekjoon.sort;

import java.util.Arrays;
import java.util.Scanner;

// 두 수의 합, 실버 III
public class 두수의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] numList = new int[n];

        for (int i = 0; i < n; i++) {
            numList[i] = sc.nextInt();
        }
        int x = sc.nextInt();

        Arrays.sort(numList);

        int count = 0;
        int left = 0;
        int right = n - 1;

        while (left < right) {
            int sum = numList[left] + numList[right];

            if (sum == x) {
                count++;
            }
            if (sum < x) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(count);
    }
}
