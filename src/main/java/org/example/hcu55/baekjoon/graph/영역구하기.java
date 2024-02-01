package org.example.hcu55.baekjoon.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 영역 구하기, 실버 I
public class 영역구하기 {
    static int M, N, K;
    static int[][] area;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int size;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();

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

        ArrayList<Integer> areaList = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (area[i][j] == 0) {
                    size = 0;               // 영역 크기 초기화
                    dfs(i, j);
                    areaList.add(size);
                }
            }
        }

        Collections.sort(areaList);        // 오름차순 정렬

        StringBuilder sb = new StringBuilder();

        sb.append(areaList.size()).append('\n');   // size = 영역의 개수
        for (int i : areaList) {
            sb.append(i + " ");
        }
        System.out.println(sb);
    }

    public static void dfs(int x, int y) {
        area[x][y] = 1;
        size++;             //영역의 크기 증가

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