package org.example.yumyeonghan.baekjoon.sort;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/11399
public class ATM {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arrN = new int[n];
        for (int i = 0; i < n; i++) {
            arrN[i] = scanner.nextInt();
        }
        Arrays.sort(arrN);

        int count = 0;
        int answer = 0;
        for (int v : arrN) {
            count += v;
            answer += count;
        }
        System.out.println(answer);
    }

}
