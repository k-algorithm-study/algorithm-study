package org.example.hcu55.baekjoon.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 바이러스, 실버 III
public class 바이러스 {

    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int com = sc.nextInt();     // 컴퓨터 개수
        int e = sc.nextInt();       // 연결된 간선 수

        arr = new int[com + 1][com + 1];
        for (int i = 0; i < e; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            // 연결된 노드 1로 배정
            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        visited = new boolean[com + 1];
        bfs(1);
    }

    // bfs
    public static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();

        visited[node] = true;
        queue.add(node);
        int count = 0; // 감염 된 컴퓨터의 수

        while (!queue.isEmpty()) {
            int queue_node = queue.poll();
            for (int i = 1; i < arr.length; i++) {
                if (arr[queue_node][i] == 1 && visited[i] == false) {
                    queue.add(i);
                    visited[i] = true;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
