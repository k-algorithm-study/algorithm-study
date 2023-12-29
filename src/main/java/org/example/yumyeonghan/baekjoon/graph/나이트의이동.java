package org.example.yumyeonghan.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/7562
public class 나이트의이동 {

  private static int[][] map;
  private static boolean[][] isVisited;
  private static Queue<int[]> queue;
  private static int[] dx = {2, 2, 1, -1, -2, -2, 1, -1};
  private static int[] dy = {1, -1, 2, 2, 1, -1, -2, -2};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
      queue = new LinkedList<>();
      int len = Integer.parseInt(br.readLine());
      map = new int[len][len];
      isVisited = new boolean[len][len];
      StringTokenizer tk = new StringTokenizer(br.readLine());
      int startX = Integer.parseInt(tk.nextToken());
      int startY = Integer.parseInt(tk.nextToken());
      tk = new StringTokenizer(br.readLine());
      int endX = Integer.parseInt(tk.nextToken());
      int endY = Integer.parseInt(tk.nextToken());

      queue.add(new int[]{startX, startY});
      isVisited[startX][startY] = true;

      while (!queue.isEmpty()) {
        int[] tmp = queue.poll();
        int x = tmp[0];
        int y = tmp[1];
        if (x == endX && y == endY) {
          break;
        }
        for (int direction = 0; direction < 8; direction++) {
          int nx = x + dx[direction];
          int ny = y + dy[direction];

          if (nx >= 0 && ny >= 0 && nx < len && ny < len) {
            if (!isVisited[nx][ny] && map[nx][ny] == 0) {
              map[nx][ny] = map[x][y] + 1;
              queue.offer(new int[]{nx, ny});
            }
          }
        }
      }
      System.out.println(map[endX][endY]);
    }
  }
}
