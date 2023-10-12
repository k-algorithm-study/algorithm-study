package org.example.hcu55.baekjoon.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// DFS와 BFS, 실버 II
public class DFS와BFS {

    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   // 정점 수
        int M = sc.nextInt();   // 간선 수
        int V = sc.nextInt();   // 정점 시작 번호

        arr = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            // 연결된 노드 1로 배정
            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        visited = new boolean[N + 1];
        dfs(V);

        System.out.println();

        visited = new boolean[N + 1];
        bfs(V);
    }

    //dfs는 재귀 이용
    public static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int i = 0; i < arr.length; i++) {
            if (arr[node][i] == 1 && visited[i] == false) {
                dfs(i);
            }
        }
    }

    //bfs는 큐 이용
    public static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(node);
        visited[node] = true;
        System.out.print(node + " ");

        while (!queue.isEmpty()) {
            int queue_node = queue.poll();      // poll은 비어있으면 null 반환
            for (int i = 0; i < arr.length; i++) {
                if (arr[queue_node][i] == 1 && visited[i] == false) {
                    queue.add(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }
}
