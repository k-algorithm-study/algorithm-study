package org.example.yumyeonghan.baekjoon.dfs_bfs;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2606
public class 바이러스 {

    private static int[][] adj;
    private static int[] visited;

    public static void main(String[] args) {
        // 1. 초기화
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int infoNum = scanner.nextInt();
        adj = new int[n + 1][n + 1];
        visited = new int[n + 1];
        for (int i = 0; i < infoNum; i++) {
            int s = scanner.nextInt();
            int e = scanner.nextInt();
            adj[s][e] = 1;
            adj[e][s] = 1;
        }

        // 2. dfs 실행
        dfs(1);

        // 3. 정답 출력
        int answer = -1; // 1번 컴퓨터 제외
        for (int s : visited) {
            if (s == 1) {
                answer += 1;
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int v) {
        visited[v] = 1;
        for (int i = 1; i < adj.length; i++) {
            if (adj[v][i] == 1 && visited[i] == 0) {
                dfs(i);
            }
        }
    }

}
