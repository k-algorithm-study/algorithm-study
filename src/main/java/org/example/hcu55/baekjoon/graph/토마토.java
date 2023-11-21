package org.example.hcu55.baekjoon.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 토마토, 골드 V
public class 토마토 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;
    static int[][] tomatoMap;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        tomatoMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tomatoMap[i][j] = sc.nextInt();
                if (tomatoMap[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nx = now[0];
            int ny = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nx + dx[i];
                int nextY = ny + dy[i];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                    if (tomatoMap[nextX][nextY] == 0) {
                        tomatoMap[nextX][nextY] = tomatoMap[nx][ny] + 1;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomatoMap[i][j] == 0) {
                    return -1;
                } else {
                    max = Math.max(max, tomatoMap[i][j]);
                }
            }
        }
        return max - 1;
    }
}
