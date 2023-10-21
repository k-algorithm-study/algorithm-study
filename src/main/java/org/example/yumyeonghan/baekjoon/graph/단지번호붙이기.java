package org.example.yumyeonghan.baekjoon.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 단지번호붙이기 {

  private static int[][] graph;
  private static boolean[][] visited;
  private static int[] dx = {1, -1, 0, 0};
  private static int[] dy = {0, 0, 1, -1};
  private static int n;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    n = scanner.nextInt();
    graph = new int[n][n];
    visited = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      String s = scanner.next();
      for (int j = 0; j < n; j++) {
        graph[i][j] = s.charAt(j) - '0';
      }
    }

    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (graph[i][j] == 1 && !visited[i][j]) {
          int count = dfs(i, j, 0);
          list.add(count);
        }
      }
    }

    System.out.println(list.size());
    Collections.sort(list);
    for (int size : list) {
      System.out.println(size);
    }
  }

  private static int dfs(int x, int y, int count) {
    visited[x][y] = true;
    count++;

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
        if (graph[nx][ny] == 1 && !visited[nx][ny]) {
          count = dfs(nx, ny, count);
        }
      }
    }
    return count;
  }

}
