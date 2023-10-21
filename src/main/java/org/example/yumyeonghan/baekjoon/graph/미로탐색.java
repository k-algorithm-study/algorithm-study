package org.example.yumyeonghan.baekjoon.graph;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/2178
public class 미로탐색 {

  private static int[] dx = {1, -1, 0, 0};
  private static int[] dy = {0, 0, 1, -1};
  private static int[][] graph;
  private static int n;
  private static int m;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    n = scanner.nextInt();
    m = scanner.nextInt();
    graph = new int[n][m];
    for (int i = 0; i < n; i++) {
      String s = scanner.next();
      for (int j = 0; j < m; j++) {
        graph[i][j] = s.charAt(j) - '0';
      }
    }
    bfs(0, 0);
    System.out.println(graph[n - 1][m - 1]);
  }

  private static void bfs(int x, int y) {
    Queue<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{x, y});
    while (!queue.isEmpty()) {
      int[] now = queue.poll();
      int nowX = now[0];
      int nowY = now[1];
      for (int i = 0; i < 4; i++) {
        int nx = nowX + dx[i];
        int ny = nowY + dy[i];
        if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
          continue;
        }
        if (graph[nx][ny] == 1) {
          graph[nx][ny] = graph[nowX][nowY] + 1;
          queue.add(new int[]{nx, ny});
        }
      }
    }
  }

}
