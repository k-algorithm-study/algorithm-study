package org.example.yumyeonghan.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1987
public class 알파벳 {

  private static int[][] map;
  private static boolean[] isVisited = new boolean[26]; // 'A' - 'Z' 개수
  private static int[] dx = {1, 0, 0, -1};
  private static int[] dy = {0, 1, -1, 0};
  private static int answer;
  private static int r;
  private static int c;

  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(reader);
    StringTokenizer st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    map = new int[r][c];

    // init map
    for (int x = 0; x < r; x++) {
      String s = br.readLine();
      for (int y = 0; y < c; y++) {
        map[x][y] = s.charAt(y) - 'A';
      }
    }
    dfs(0, 0, 1);
    System.out.println(answer);
  }

  private static void dfs(int x, int y, int count) {
    int idx = map[x][y];
    isVisited[idx] = true;
    answer = Math.max(answer, count);

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
        idx = map[nx][ny];
        if (!isVisited[idx]) {
          dfs(nx, ny, count + 1);
          isVisited[idx] = false;
        }
      }
    }
  }

}
