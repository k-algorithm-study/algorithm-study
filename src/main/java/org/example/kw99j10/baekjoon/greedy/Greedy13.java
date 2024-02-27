package org.example.kw99j10.baekjoon.greedy;

import java.util.Scanner;

/**
 * 수리공 항승 - Silver III
 */
public class Greedy13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] water = new int[2001];

        int n = sc.nextInt();
        int l = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            water[k] = 1;
        }

        int count = 0;
        for (int i = 1; i <= 1000; i++) {
            if (water[i] == -1) {
                continue;
            }
            if (water[i] == 1) {
                for (int j = i; j < i + l; j++) {
                    water[j] = -1;
                }
                count++;
            }
        }
        System.out.println(count);
    }
}
