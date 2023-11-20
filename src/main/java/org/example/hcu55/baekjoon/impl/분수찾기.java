package org.example.hcu55.baekjoon.impl;

import java.util.Scanner;

// 분수찾기, 실버 V
public class 분수찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();
        int count = 0;          // 수열의 수 ex) 1 / 3 / 6 / 10 / 15 ...
        int i = 0;              // 수열이 몇 번째인지
        int denominator = 0;    // 분모
        int numerator = 0;      // 분자

        while (X > count) {     // 해당 수가 몇 번째 수열에 있는지 확인
            i++;
            count += i;         // 마지막 수열의 차례
        }
        if (i % 2 == 0) {       // 짝수일 때
            denominator = 1 + (count - X);  // 분모
            numerator = i - (count - X);    // 분자
        } else {
            denominator = i - (count - X);
            numerator = 1 + (count - X);
        }
        System.out.println(numerator + "/" + denominator);
    }
}