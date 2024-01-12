package org.example.hcu55.baekjoon.dfs_bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 영역 구하기, 실버 I
public class 영역구하기 {

    static int M, N, K;
    static int[][] area;
    static int count;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();   // 세로
        N = sc.nextInt();   // 가로
        K = sc.nextInt();   // 좌표 개수

        area = new int[M][N];

        for (int i = 0; i < K; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    area[y][x] = 1;
                }
            }
        }
        ArrayList<Integer> areaSize = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (area[i][j] == 0) {
                    count = 0;          // 영역 개수 초기화
                    dfs(i, j);
                    areaSize.add(count);
                }
            }
        }
        Collections.sort(areaSize);
        System.out.println(areaSize.size());
        for (Integer integer : areaSize) {
            System.out.print(integer + " ");
        }
    }

    static void dfs(int x, int y) {
        area[x][y] = 1;
        count++;

        for (int k = 0; k < 4; k++) {
            int nextX = x + dx[k];
            int nextY = y + dy[k];

            if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
                if (area[nextX][nextY] == 0) {
                    dfs(nextX, nextY);
                }
            }
        }
    }
}
