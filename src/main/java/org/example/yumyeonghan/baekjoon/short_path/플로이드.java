package org.example.yumyeonghan.baekjoon.short_path;

import java.util.Scanner;

/**
 * 가중치 개념이 없는 단순 최소 경로 문제 -> BFS 가중치 개념이 있는 한 노드 기준의 최소 경로 값 -> Dijkstra (다익스트라) 가중치 개념이 있는 모든 노드
 * 기준의 최소 경로 값 -> Floyd Warshall(플로이드 와샬)
 */

// https://www.acmicpc.net/problem/11404
public class 플로이드 {

  static final int INF = (int) 1e9;
  static int n, m; // 노드의 개수(n), 간선의 개수(m)
  static int[][] graph;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    n = scanner.nextInt();
    m = scanner.nextInt();
    graph = new int[n + 1][n + 1];

    // 1. 최단 거리 테이블 초기화 (자신 -> 자신 가는 비용은 0으로 초기화)
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        graph[i][j] = INF;
        if (i == j) {
          graph[i][j] = 0;
        }
      }
    }

    // 2. 간선 정보 입력 및 더 작은값 초기화
    for (int i = 0; i < m; i++) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      int c = scanner.nextInt();
      graph[a][b] = Math.min(graph[a][b], c);
    }

    // 3. 플로이드 워셜 실행
    for (int i = 1; i <= n; i++) {
      for (int a = 1; a <= n; a++) {
        for (int b = 1; b <= n; b++) {
          graph[a][b] = Math.min(graph[a][b], graph[a][i] + graph[i][b]);
        }
      }
    }

    // 4. 결과 출력
    for (int a = 1; a <= n; a++) {
      StringBuilder stringBuilder = new StringBuilder();
      for (int b = 1; b <= n; b++) {
        if (graph[a][b] == INF) {
          stringBuilder.append(0 + " ");
        } else {
          stringBuilder.append(graph[a][b] + " ");
        }
      }
      System.out.println(stringBuilder);
    }
  }

}
