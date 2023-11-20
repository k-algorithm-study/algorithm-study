package org.example.hcu55.baekjoon.impl;

import java.util.Scanner;
import java.util.Stack;

// 제로, 실버 IV
public class 제로 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int sum = 0;
        Stack<Integer> money = new Stack<>();

        for (int i = 0; i < K; i++) {
            int number = sc.nextInt();

            if (number == 0) {
                money.pop();
            } else {
                money.push(number);
            }
        }
        for (int num : money) {
            sum += num;
        }
        System.out.println(sum);
    }
}
