package org.example.yumyeonghan.baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1012
public class 유기농배추 {

  // 배추밭의 가로 길이(x), 열
  private static int m;

  // 배추밭의 세로 길이(y), 행
  private static int n;

  // 배추밭
  private static int[][] graph;

  // 구역 방문 여부
  private static boolean[][] isVisited;

  // 상하좌우
  private static int[] dx = {0, 0, -1, 1};
  private static int[] dy = {-1, 1, 0, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    // 케이스 수
    int t = Integer.parseInt(reader.readLine());

    for (int i = 0; i < t; i++) {
      String[] temp = reader.readLine().split(" ");

      m = Integer.parseInt(temp[0]);

      n = Integer.parseInt(temp[1]);

      // 배추 갯수
      int k = Integer.parseInt(temp[2]);

      graph = new int[m][n];
      isVisited = new boolean[m][n];
      int answer = 0;

      // 배추 좌표 표시
      for (int j = 0; j < k; j++) {
        temp = reader.readLine().split(" ");
        int x = Integer.parseInt(temp[0]);
        int y = Integer.parseInt(temp[1]);
        graph[x][y] = 1;
      }

      for (int y = 0; y < n; y++) {
        for (int x = 0; x < m; x++) {
          if (graph[x][y] == 1 && !isVisited[x][y]) {
            answer += 1;
            dfs(x, y);
          }
        }
      }
      System.out.println(answer);
    }
    reader.close();
  }

  private static void dfs(int x, int y) {
    isVisited[x][y] = true;
    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if ((nx > -1 && nx < m) && (ny > -1 && ny < n) && graph[nx][ny] == 1 && !isVisited[nx][ny]) {
        dfs(nx, ny);
      }
    }
  }

}
