package org.example.hcu55.baekjoon.shortpath;

import java.util.Scanner;

// 케빈 베이컨의 6단계 법칙, 실버 I
public class 케빈베이컨의6단계법칙 {
    static final int INF = 10000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] node = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {      // 초기값 세팅
            for (int j = 1; j <= N; j++) {
                node[i][j] = INF;
            }
            node[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {       // 친구 관계 입력
            int x = sc.nextInt();
            int y = sc.nextInt();

            node[x][y] = node[y][x] = 1;
        }

        for (int k = 1; k <= N; k++) {      // 플로이드-워샬
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (node[i][j] > node[i][k] + node[k][j]) {
                        node[i][j] = node[i][k] + node[k][j];
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                sum += node[i][j];
            }
            if (sum < min) {       // 케빈 베이컨 수가 가장 작은 사람 저장
                min = sum;
                minIndex = i;
            }
        }
        System.out.println(minIndex);
    }
}
