package org.example.hcu55.baekjoon.greedy;

import java.util.Scanner;

// 수들의 합, 실버 V
public class 수들의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long S = sc.nextLong();         // nextLong() 개억까
        long count = 1L;

        while (true) {
            S -= count;
            if (S < 0) {
                break;
            }
            count += 1;
        }
        System.out.println(count - 1);
    }
}