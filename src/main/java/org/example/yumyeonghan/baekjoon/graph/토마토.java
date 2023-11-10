package org.example.yumyeonghan.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/7576
public class 토마토 {

  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  static int n, m;
  static int[][] graph;
  static Queue<int[]> queue = new LinkedList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    m = Integer.parseInt(stringTokenizer.nextToken());
    n = Integer.parseInt(stringTokenizer.nextToken());
    graph = new int[n][m];

    for (int i = 0; i < n; i++) {
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      for (int j = 0; j < m; j++) {
        graph[i][j] = Integer.parseInt(stringTokenizer.nextToken());
        if (graph[i][j] == 1) {
          queue.add(new int[]{i, j});
        }
      }
    }
    bfs();
  }

  private static void bfs() {
    while (!queue.isEmpty()) {
      int[] tmp = queue.poll();
      int x = tmp[0];
      int y = tmp[1];
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
          continue;
        }
        if (graph[nx][ny] == 0) {
          graph[nx][ny] = graph[x][y] + 1;
          queue.add(new int[]{nx, ny});
        }
      }
    }
    // 덜익은 토마토 있는지 확인
    if (checkZero()) {
      System.out.println(-1);
    } else {
      System.out.println(checkMax());
    }
  }

  static int checkMax() {
    int answer = -(int) 1e9;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        answer = Math.max(answer, graph[i][j]);
      }
    }
    // graph[i][j] 가 1인, 익은 토마토 위치의 값을 빼야함, 그 다음 위치의 날짜는 2일이 아닌, 1일 이므로
    return answer - 1;
  }

  static boolean checkZero() {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (graph[i][j] == 0) {
          return true;
        }
      }
    }
    return false;
  }

}
