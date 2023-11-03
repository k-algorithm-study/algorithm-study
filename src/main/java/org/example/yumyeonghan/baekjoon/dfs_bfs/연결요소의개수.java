package org.example.yumyeonghan.baekjoon.dfs_bfs;

import java.util.Scanner;

public class 연결요소의개수 {

  private static int n;
  private static int m;
  private static boolean[] isChecked;
  private static int[][] graph;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int answer = 0;
    n = sc.nextInt(); // 정점 개수
    m = sc.nextInt(); // 간선 개수

    graph = new int[1001][1001];
    isChecked = new boolean[1001];

    // 간선 상태 표시
    for (int i = 0; i < m; i++) {
      int u = sc.nextInt();
      int v = sc.nextInt();
      graph[u][v] = 1;
      graph[v][u] = 1;
    }

    for (int i = 1; i <= n; i++) {
      if (!isChecked[i]) {
        answer += 1;
        dfs(i);
      }
    }
    System.out.println(answer);
  }

  private static void dfs(int node) {
    isChecked[node] = true;
    for (int i = 1; i <= n; i++) {
      if (graph[node][i] == 1 && !isChecked[i]) {
        dfs(i);
      }
    }
  }

}
