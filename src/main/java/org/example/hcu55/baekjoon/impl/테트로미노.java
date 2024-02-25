package org.example.hcu55.baekjoon.impl;

import java.util.*;
import java.io.*;

// 테트로미노, 골드 IV
public class 테트로미노 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;
    static int[][] area;
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        area = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, area[i][j], 1);
                visited[i][j] = false;
            }
        }
        System.out.println(max);
    }

    static void dfs(int x, int y, int sum, int depth) {

        if (depth == 4) {               // 깊이 4까지만 진행
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                if (!visited[nextX][nextY]) {

                    if (depth == 2) {                   // ㅓ, ㅏ, ㅗ, ㅜ 모양 탐색하기 위해 depth=2에서 다시 탐색
                        visited[nextX][nextY] = true;
                        dfs(x, y, sum + area[nextX][nextY], depth + 1);
                        visited[nextX][nextY] = false;
                    }

                    visited[nextX][nextY] = true;
                    dfs(nextX, nextY, sum + area[nextX][nextY], depth + 1);
                    visited[nextX][nextY] = false;
                }
            }
        }
    }
}
