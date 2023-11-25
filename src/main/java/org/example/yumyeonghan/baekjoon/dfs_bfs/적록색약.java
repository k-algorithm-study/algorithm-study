package org.example.yumyeonghan.baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/10026
public class 적록색약 {

  static char graph[][];
  static boolean isVisited[][];
  static int[] dx = {0, -1, 0, 1};
  static int[] dy = {-1, 0, 1, 0};
  static int n;
  static int notRGB = 0;
  static int RGB = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(bufferedReader.readLine());
    graph = new char[n][n];
    isVisited = new boolean[n][n];
    // 그래프 초기화
    for (int i = 0; i < n; i++) {
      String str = bufferedReader.readLine();
      for (int j = 0; j < n; j++) {
        graph[i][j] = str.charAt(j);
      }
    }
    // 일반인 탐색
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!isVisited[i][j]) {
          dfs(i, j);
          notRGB++;
        }
      }
    }
    // 적록색약(초록 == 빨강) 준비 작업
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (graph[i][j] == 'G')  // 초록 -> 빨강으로 변경
        {
          graph[i][j] = 'R';
        }
      }
    }
    isVisited = new boolean[n][n];

    // 적록색약 탐색
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!isVisited[i][j]) {
          dfs(i, j);
          RGB++;
        }
      }
    }
    System.out.println(notRGB + " " + RGB);
  }

  public static void dfs(int x, int y) {
    isVisited[x][y] = true;
    char color = graph[x][y];
    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
        // 상하좌우중 같은색의 약이고 방문하지 않은곳 dfs
        if (graph[nx][ny] == color && !isVisited[nx][ny]) {
          dfs(nx, ny);
        }
      }
    }
  }

}
