package org.example.hcu55.baekjoon.dfs_bfs;

import java.util.*;

// 내리막 길, 골드 III
public class 내리막길 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int M, N;
    static int[][] map, dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();

        map = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }

    public static int dfs(int x, int y) {
        if (x == M - 1 && y == N - 1) {     // 도달했을 때 종료
            return 1;
        }
        if (dp[x][y] != -1) {               // -1이 아니면 방문했다.
            return dp[x][y];
        }

        dp[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
                if (map[x][y] > map[nextX][nextY]) {
                    dp[x][y] += dfs(nextX, nextY);
                }
            }
        }
        return dp[x][y];
    }
}
