package org.example.hcu55.baekjoon.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 30, 실버 IV
public class 삼십 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String N = sc.next();
        Integer numArr[] = new Integer[N.length()];
        int numSum = 0;

        for (int i = 0; i < N.length(); i++) {
            numArr[i] = N.charAt(i) - '0';
            numSum += numArr[i];
        }

        Arrays.sort(numArr, Collections.reverseOrder());    // 큰 수 부터 정렬

        if ((numSum % 3 == 0) && (numArr[N.length() - 1] == 0)) {    // 30의 배수는 0이 존재하고 각 자리 합 3으로 나누어 떨어지면됨
            for (int i = 0; i < N.length(); i++) {
                System.out.print(numArr[i]);
            }
        } else {
            System.out.println(-1);
        }
    }
}
