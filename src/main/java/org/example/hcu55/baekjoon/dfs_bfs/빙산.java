package org.example.hcu55.baekjoon.dfs_bfs;

import java.util.*;
import java.io.*;

// 빙산, 골드 IV
public class 빙산 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;
    static int[][] area;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        area = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;

        while (true) {
            int result = countIsland();

            if (result >= 2) {
                break;
            } else if (result == 0) {
                year = 0;
                break;
            }

            bfs();
            year++;
        }
        System.out.println(year);
    }

    public static int countIsland() {
        int count = 0;
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (area[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                if (area[nextX][nextY] != 0 && !visited[nextX][nextY]) {
                    dfs(nextX, nextY);
                }
            }
        }
    }

    public static void bfs() {    // 빙산 녹이는 메소드
        Queue<IceBerg> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (area[i][j] > 0) {
                    queue.add(new IceBerg(i, j));
                    visited[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            IceBerg ice = queue.poll();

            int sea = 0;

            for (int i = 0; i < 4; i++) {
                int nextX = ice.x + dx[i];
                int nextY = ice.y + dy[i];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                    if (!visited[nextX][nextY] && area[nextX][nextY] == 0) {
                        sea++;
                    }
                }
            }
            if (area[ice.x][ice.y] - sea < 0) {
                area[ice.x][ice.y] = 0;
            } else {
                area[ice.x][ice.y] -= sea;
            }
        }
    }

    static class IceBerg {
        int x;
        int y;

        public IceBerg(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
