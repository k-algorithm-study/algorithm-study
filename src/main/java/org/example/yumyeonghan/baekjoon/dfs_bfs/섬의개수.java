package org.example.yumyeonghan.baekjoon.dfs_bfs;

import java.util.Scanner;

// https://www.acmicpc.net/problem/4963
public class 섬의개수 {

  private static int count;
  private static int dx[] = {0, 0, -1, 1, -1, 1, -1, 1};
  private static int dy[] = {-1, 1, 0, 0, 1, 1, -1, -1};
  private static int w;
  private static int h;
  private static int[][] map;
  private static boolean[][] isVisited;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      // input value
      count = 0;
      h = sc.nextInt();
      w = sc.nextInt();
      sc.nextLine();

      // exit condition
      if (w == 0 && h == 0) {
        break;
      }

      // init map
      map = new int[w][h];
      isVisited = new boolean[w][h];
      for (int i = 0; i < w; i++) {
        String tmp = sc.nextLine();
        String[] nums = tmp.split(" ");
        for (int j = 0; j < nums.length; j++) {
          map[i][j] = Integer.parseInt(nums[j]);
        }
      }
      // start search
      for (int i = 0; i < w; i++) {
        for (int j = 0; j < h; j++) {
          if (map[i][j] == 1 && !isVisited[i][j]) {
            dfs(i, j);
            count += 1;
          }
        }
      }
      System.out.println(count);
    }
  }

  private static void dfs(int x, int y) {
    isVisited[x][y] = true;
    for (int i = 0; i < 8; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (nx >= 0 && nx < w && ny >= 0 && ny < h) {
        if (map[nx][ny] == 1 && !isVisited[nx][ny]) {
          dfs(nx, ny);
        }
      }
    }
  }

}
