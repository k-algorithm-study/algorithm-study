package org.example.kw99j10.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 테트로미노 - Gold IV
 */
public class Implementation14 {
    static int n, m;
    static int[][] paper;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int max; //수들의 합 최댓값
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        paper = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit[i][j] = true;
                dfs(i, j, 1, paper[i][j]); //좌표 별 모든 경우의 수 탐색
                visit[i][j] = false;
            }
        }
        System.out.println(max);
    }

    static void dfs(int x, int y, int count, int sum){

        if (count == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny]) {
                continue;
            }

            //'ㅜ'모양 처리
            if (count == 2) {
                visit[nx][ny] = true;
                dfs(x, y, count + 1, sum + paper[nx][ny]);
                visit[nx][ny] = false;
            }

            visit[nx][ny] = true;
            dfs(nx, ny, count + 1, sum + paper[nx][ny]);
            visit[nx][ny] = false;
        }
    }
}
