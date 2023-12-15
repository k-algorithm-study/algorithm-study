package org.example.hcu55.baekjoon.impl;

import java.util.Scanner;

// 덩치, 실버 V
public class 덩치 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] weightHeight = new int[N][2];

        for (int i = 0; i < N; i++) {       // 몸무게 키 입력받기
            weightHeight[i][0] = sc.nextInt();
            weightHeight[i][1] = sc.nextInt();
        }
        int rank = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (weightHeight[i][0] < weightHeight[j][0]) {  // 자신보다 몸무게도 크고
                    if (weightHeight[i][1] < weightHeight[j][1]) {  // 키도 큰 사람이 있다면
                        rank++; // 등수 증가
                    }
                }
            }
            System.out.print(rank + 1 + " ");
            rank = 0;
        }
    }
}
