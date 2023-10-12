package org.example.yumyeonghan.baekjoon.dfs_bfs;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class DFS와BFS {

    private static int[] dfsVisited;
    private static int[] bfsVisited;
    private static int[][] adj;

    public static void main(String[] args) {

        //1. 초기화
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int v = scanner.nextInt();
        adj = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int s = scanner.nextInt();
            int e = scanner.nextInt();
            adj[s][e] = 1;
            adj[e][s] = 1;
        }
        dfsVisited = new int[n + 1];
        bfsVisited = new int[n + 1];

        //2. dfs && bfs 실행
        dfs(v);
        System.out.println();
        bfs(v);
    }

    private static void dfs(int v) {
        dfsVisited[v] = 1;
        System.out.print(v + " ");
        for (int i = 1; i < adj.length; i++) {
            if (adj[v][i] == 1 && dfsVisited[i] == 0) {
                dfs(i);
            }
        }
    }

    private static void bfs(int v) {
        bfsVisited[v] = 1;
        System.out.print(v + " ");
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(v);
        while (!queue.isEmpty()) {
            Integer e = queue.poll();
            for (int i = 1; i < adj.length; i++) {
                if (adj[e][i] == 1 && bfsVisited[i] == 0) {
                    bfsVisited[i] = 1;
                    System.out.print(i + " ");
                    queue.add(i);
                }
            }
        }
    }

}
