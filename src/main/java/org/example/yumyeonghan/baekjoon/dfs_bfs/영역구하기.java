package org.example.yumyeonghan.baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2583
public class 영역구하기 {

  static int m, n, count = 0;
  static int[][] map;
  static List<Integer> list = new LinkedList<>();
  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    map = new int[m][n];
    for (int c = 0; c < K; c++) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());
      for (int i = y1; i < y2; i++) {
        for (int j = x1; j < x2; j++) {
          map[i][j] = 1;
        }
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (map[i][j] == 0) {
          list.add(bfs(i, j));
          count++;
        }
      }
    }

    Collections.sort(list);

    System.out.println(count);
    for (int i : list) {
      System.out.print(i + " ");
    }
  }

  static int bfs(int x, int y) {
    Queue<Node> q = new LinkedList<>();
    q.offer(new Node(x, y));
    map[x][y] = 1;
    int sum = 1;

    while (!q.isEmpty()) {
      Node a = q.poll();

      for (int i = 0; i < 4; i++) {
        int nx = a.row + dx[i];
        int ny = a.col + dy[i];

        if (nx < 0 || ny < 0 || nx >= m || ny >= n || map[nx][ny] == 1) {
          continue;
        }

        sum++;
        q.offer(new Node(nx, ny));
        map[nx][ny] = 1;
      }
    }

    return sum;
  }

  static class Node {

    int row, col;

    Node(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }

}
