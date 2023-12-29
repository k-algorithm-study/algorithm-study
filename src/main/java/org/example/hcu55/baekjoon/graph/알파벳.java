package org.example.hcu55.baekjoon.graph;

import java.util.Scanner;

// 알파벳, 골드 IV
public class 알파벳 {
    static int r, c;
    static int[][] arr;
    static boolean[] visited;
    static int max = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();

        arr = new int[r][c];
        visited = new boolean[26];      // 알파벳 26개
        for (int i = 0; i < r; i++) {
            String input = sc.next();
            for (int j = 0; j < c; j++) {
                arr[i][j] = input.charAt(j) - 'A';
            }
        }
        dfs(0, 0, 1);
        System.out.println(max);
    }

    public static void dfs(int x, int y, int cnt) {
        visited[arr[x][y]] = true;
        max = Math.max(max, cnt);

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextY >= 0 && nextX < r && nextY < c) {
                if (visited[arr[nextX][nextY]] == false) {      // 방문하지 않은 곳
                    dfs(nextX, nextY, cnt + 1);
                    visited[arr[nextX][nextY]] = false;         // 백트레킹으로 다시 미방문 처리
                }
            }
        }
    }
}