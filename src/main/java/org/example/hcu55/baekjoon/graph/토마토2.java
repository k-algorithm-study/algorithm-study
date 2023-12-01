package org.example.hcu55.baekjoon.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 토마토2, 골드 V
public class 토마토2 {     // 토마토 1에서 height만 추가해서 구현하면 끝이다.
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int N, M, H;
    static int[][][] tomatoMap;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();
        tomatoMap = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    tomatoMap[i][j][k] = sc.nextInt();
                    if (tomatoMap[i][j][k] == 1) {
                        queue.add(new int[]{i, j, k});
                    }
                }
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nz = now[0];
            int nx = now[1];
            int ny = now[2];

            for (int i = 0; i < 6; i++) {
                int nextZ = nz + dz[i];
                int nextX = nx + dx[i];
                int nextY = ny + dy[i];

                if (nextZ >= 0 && nextZ < H && nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                    if (tomatoMap[nextZ][nextX][nextY] == 0) {
                        tomatoMap[nextZ][nextX][nextY] = tomatoMap[nz][nx][ny] + 1;
                        queue.add(new int[]{nextZ, nextX, nextY});
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (tomatoMap[i][j][k] == 0) {
                        return -1;
                    } else {
                        max = Math.max(max, tomatoMap[i][j][k]);
                    }
                }
            }
        }
        return max - 1;
    }
}
