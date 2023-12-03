package org.example.hcu55.baekjoon.graph;

import java.util.Scanner;

// 안전 영역, 실버 I
public class 안전영역 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;
    static int[][] area;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        area = new int[N][N];

        int maxHeight = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                area[i][j] = sc.nextInt();
                if (maxHeight < area[i][j]) {
                    maxHeight = area[i][j];
                }
            }
        }

        int safeArea = 0;
        for (int h = 0; h <= maxHeight; h++) {  // 비 높이
            int count = 0;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (area[i][j] > h && !visited[i][j]) {
                        count++;
                        dfs(h, i, j);
                    }
                }
            }
            safeArea = Math.max(safeArea, count);
        }
        System.out.println(safeArea);
    }

    static void dfs(int height, int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                if (!visited[nextX][nextY] && area[nextX][nextY] > height) {
                    visited[nextX][nextY] = true;
                    dfs(height, nextX, nextY);
                }
            }
        }
    }
}
