package org.example.hcu55.baekjoon.binarySearch;

import java.util.Scanner;

// 개똥벌레, 골드 V
public class 개똥벌레 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int H = sc.nextInt();
        int[] top = new int[H + 2];
        int[] bottom = new int[H + 2];

        for (int i = 1; i <= N / 2; i++) {
            int a = sc.nextInt();                // 석순
            int b = H - sc.nextInt() + 1;        // 종유석
            bottom[a]++;
            top[b]++;
        }
        for (int i = 1; i <= H; i++) {
            bottom[i] += bottom[i - 1];
        }

        for (int i = H; i >= 1; i--) {
            top[i] += top[i + 1];
        }

        int min = N;
        int cnt = 0;
        for (int i = 1; i < H + 1; i++) {
            int sum = (bottom[H] - bottom[i - 1]) + (top[1] - top[i + 1]);

            if (sum < min) {
                min = sum;
                cnt = 1;
            } else if (sum == min) cnt++;
        }
        System.out.println(min + " " + cnt);
    }
}
