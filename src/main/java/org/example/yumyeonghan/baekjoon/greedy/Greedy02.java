package org.example.yumyeonghan.baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

//동전 0, 실버4
public class Greedy02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int answer = 0;
        int[] moneys = new int[n];
        for (int i = 0; i < n; i++) {
            moneys[i] = -scanner.nextInt();
        }
        Arrays.sort(moneys);
        for (int i = 0; i < n; i++) {
            if (k / -moneys[i] > 0) {
                answer += k / -moneys[i];
                k %= -moneys[i];
            }
        }
        System.out.println(answer);
    }

}
