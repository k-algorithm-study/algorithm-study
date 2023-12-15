package org.example.kw99j10.baekjoon.implementation;

import java.util.Scanner;

/**
 * 덩치 - Silver V
 */
public class Implementation07 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {

            int rank = 1;

            //키와 몸무게 모두 클 경우만 순위 증가
            for (int j = 0; j < n; j++) {
                if (arr[j][0] > arr[i][0] && arr[j][1] > arr[i][1]) {
                    rank += 1;
                }
            }
            System.out.print(rank + " ");
        }
    }
}
