package org.example.hcu55.baekjoon.greedy;

import java.util.Scanner;

// 뒤집기, 실버 V
public class 뒤집기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();

        int one = 0;
        int zero = 0;

        if (S.charAt(0) == '1') {
            one++;
        } else {
            zero++;
        }

        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) != S.charAt(i - 1)) {
                if (S.charAt(i) == '1') {
                    one++;
                } else {
                    zero++;
                }
            }
        }
        System.out.println(Math.min(one, zero));
    }
}
