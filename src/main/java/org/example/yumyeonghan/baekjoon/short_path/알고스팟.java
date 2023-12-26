package org.example.yumyeonghan.baekjoon.short_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1261
public class 알고스팟 {

  static int n, m;
  static int[][] map;
  static boolean[][] isVisited;
  static int[] dx = {0, 0, -1, 1};
  static int[] dy = {1, -1, 0, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());

    // init map
    map = new int[n][m];
    isVisited = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      for (int j = 0; j < m; j++) {
        map[i][j] = s.charAt(j) - '0';
      }
    }

    // search map (bfs)
    System.out.println(bfs(0, 0));
  }

  private static int bfs(int x, int y) {
    PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> n1.count - n2.count);

    // init priority queue
    int minCount = (int) 1e9;
    queue.add(new Node(x, y, 0));
    isVisited[x][y] = true;

    // start bfs
    while (!queue.isEmpty()) {
      Node node = queue.poll();
      int currentX = node.x;
      int currentY = node.y;

      // normal exit condition
      if (currentX == n - 1 && currentY == m - 1) {
        minCount = Math.min(minCount, node.count);
        return minCount;
      }

      // search 4 directions
      for (int i = 0; i < 4; i++) {
        int nx = currentX + dx[i];
        int ny = currentY + dy[i];

        if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
          continue;
        }

        if (!isVisited[nx][ny]) {
          if (map[nx][ny] == 0) {
            queue.add(new Node(nx, ny, node.count)); // 뚫려 있다면 그냥 가고
          }
          if (map[nx][ny] == 1) {
            queue.add(new Node(nx, ny, node.count + 1)); // 막혀 있다면 부쉬고 간다
          }
          isVisited[nx][ny] = true;
        }
      }
    }
    return -1;
  }


  private static class Node {

    private int x;
    private int y;
    private int count;

    public Node(int x, int y, int count) {
      this.x = x;
      this.y = y;
      this.count = count;
    }

  }

}
