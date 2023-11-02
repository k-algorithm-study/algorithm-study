package org.example.hcu55.baekjoon.dfs_bfs;

import java.util.Scanner;

// 연결 요소의 개수, 실버 II
public class 연결요소의개수 {
    static int V;    // 노드
    static int E;    // 간선
    static int[][] graph = new int[1001][1001];
    static boolean[] visited = new boolean[1001];

    public static void dfs(int node) {
        visited[node] = true;
        for (int i = 1; i <= V; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        E = sc.nextInt();
        int count = 0;

        for (int i = 0; i < E; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x][y] = graph[y][x] = 1;     // 간선 연결
        }

        for (int i = 1; i <= V; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }
}

