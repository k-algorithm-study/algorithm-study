package org.example.hcu55.baekjoon.test;

import java.util.*;

public class DFS와BFS {
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();       // 정점
        int M = sc.nextInt();       // 간선
        int V = sc.nextInt();       // 탐색 시작 정점 번호

        graph = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        visited = new boolean[N + 1];
        dfs(V);

        System.out.println();

        visited = new boolean[N + 1];
        bfs(V);

    }

    public static void dfs(int n) {
        visited[n] = true;
        System.out.print(n + " ");

        for (int i = 0; i < graph.length; i++) {
            if (graph[n][i] == 1 && visited[i] == false) {
                dfs(i);
            }
        }
    }

    public static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(n);
        visited[n] = true;
        System.out.print(n + " ");

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 0; i < graph.length; i++) {
                if (graph[now][i] == 1 && visited[i] == false) {
                    queue.add(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }
}
