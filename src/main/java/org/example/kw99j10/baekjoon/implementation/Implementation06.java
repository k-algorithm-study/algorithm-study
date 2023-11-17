package org.example.kw99j10.baekjoon.implementation;

import java.util.Scanner;
import java.util.Stack;

/**
 * 제로 - Silver IV
 */
public class Implementation06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();

        var s = new Stack<Integer>(); //재민이가 부른 수를 담을 스택

        for (int i = 0; i < k; i++) {

            int num = sc.nextInt();

            if (!s.isEmpty() && num == 0) {
                s.pop(); //잘못된 수 -> 최근에 쓴 수를 지음
            }
            else {
                s.push(num);
            }
        }

        int sum = 0; //수의 최종 합

        while (!s.isEmpty()) {
            sum += s.pop();
        }
        System.out.println(sum);
    }
}
