package org.example.yumyeonghan.baekjoon.short_path;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/4485
public class 녹색옷입은애가젤다지 {

  private static int dx[] = {0, 0, -1, 1};
  private static int dy[] = {-1, 1, 0, 0};
  private static boolean isVisited[][];
  private static int map[][];
  private static int size[][];

  private static final int INF = Integer.MAX_VALUE / 4;
  private static int n, nx, ny;

  static class Node {

    int x;
    int y;
    int size;

    public Node(int x, int y, int size) {
      this.x = x;
      this.y = y;
      this.size = size;
    }

  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int problem = 1;

    String temp;
    while (!(temp = br.readLine()).isEmpty()) {

      // init map, size
      n = Integer.parseInt(temp);
      if (n == 0) {
        break;
      }

      map = new int[n][n];
      isVisited = new boolean[n][n];
      size = new int[n][n];

      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
          map[i][j] = Integer.parseInt(st.nextToken());
          size[i][j] = INF;
        }
      }

      // start bfs + 다익스트라 알고리즘
      bfs(0, 0, map[0][0]);
      sb.append("Problem ").append(problem).append(": ").append(size[n - 1][n - 1]).append('\n');
      problem++;
    }

    System.out.println(sb);

  }

  private static void bfs(int x, int y, int rupee) {
    PriorityQueue<Node> que = new PriorityQueue<>((a, b) -> a.size - b.size);
    isVisited[x][y] = true;
    que.offer(new Node(x, y, rupee));

    while (!que.isEmpty()) {
      Node node = que.poll();
      for (int i = 0; i < 4; i++) {
        nx = node.x + dx[i];
        ny = node.y + dy[i];
        if ((nx >= 0 && ny >= 0 && nx < n && ny < n) && !isVisited[nx][ny] && size[nx][ny] > (
            map[nx][ny]
                + node.size)) {
          size[nx][ny] = map[nx][ny] + node.size;
          isVisited[nx][ny] = true;
          que.offer(new Node(nx, ny, size[nx][ny]));
        }

      }
    }

  }

}
