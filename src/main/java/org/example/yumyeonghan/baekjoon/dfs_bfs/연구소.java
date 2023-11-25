package org.example.yumyeonghan.baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/14502
public class 연구소 {

  private static int n, m;
  private static int[] dx = {-1, 1, 0, 0};
  private static int[] dy = {0, 0, -1, 1};
  private static int[][] map;
  private static int[][] virusMap;
  private static int max = -(int) 1e9;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    map = new int[n][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    wall(0);
    System.out.println(max);
  }

  private static void wall(int count) {
    if (count == 3) {
      bfs(); // 바이러스 퍼트리기
      return;
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (map[i][j] == 0) {
          map[i][j] = 1;
          wall(count + 1);
          map[i][j] = 0;
        }
      }
    }
  }

  private static void bfs() {
    Queue<int[]> q = new LinkedList<>();
    virusMap = new int[n][m];
    // 바이러스 맵을 초기화하고, 바이러스 좌표를 큐에 삽입
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        virusMap[i][j] = map[i][j];
        if (virusMap[i][j] == 2) {
          q.add(new int[]{i, j});
        }
      }
    }
    // 바이러스 감염 시작
    while (!q.isEmpty()) {
      int[] tmp = q.poll();
      int x = tmp[0];
      int y = tmp[1];
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx >= 0 && nx < n && ny >= 0 && ny < m && virusMap[nx][ny] == 0) {
          virusMap[nx][ny] = 2;
          q.add(new int[]{nx, ny});
        }
      }
    }
    // 안전영역 (0) 개수 구하기
    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (virusMap[i][j] == 0) {
          count++;
        }
      }
    }
    max = Math.max(max, count);
  }

}
