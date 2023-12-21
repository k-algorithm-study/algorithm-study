package org.example.hcu55.baekjoon.dfs_bfs;

import java.util.Scanner;

// 섬의 개수, 실버 II
public class 섬의개수 {
    static int[][] area;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};
    static int w;
    static int h;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            h = sc.nextInt();
            w = sc.nextInt();

            if (w == 0 && h == 0) {     // 0 0 형식으로 입력이 들어올 때 끝내야함
                break;
            }

            area = new int[w][h];
            visited = new boolean[w][h];

            for (int i = 0; i < w; i++) {       // 지도 입력받기
                for (int j = 0; j < h; j++) {
                    area[i][j] = sc.nextInt();
                }
            }

            int count = 0;

            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (area[i][j] == 1 && !visited[i][j]) {    // 섬이거나 방문하지 않은 곳
                        dfs(i, j);                              // dfs 탐색
                        count++;                                // 섬의 개수 증가
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextY >= 0 && nextX < w && nextY < h) {
                if (area[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                    dfs(nextX, nextY);
                }
            }
        }
    }
}