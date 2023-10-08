package org.example.yumyeonghan.baekjoon.greedy;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2839
public class 설탕배달 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int answer = 0;
        while (true) {
            if (n % 5 == 0) {
                System.out.println(n / 5 + answer);
                break;
            }

            if (n < 3) {
                System.out.println(-1);
                break;
            }
            n -= 3;
            answer += 1;
        }
    }

}
