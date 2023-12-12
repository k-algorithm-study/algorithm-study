package org.example.yumyeonghan.baekjoon.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/7569
public class 토마토2 {

  private static int[] rz = {0, 0, 0, 0, -1, 1};
  private static int[] ry = {0, 0, -1, 1, 0, 0};
  private static int[] rx = {-1, 1, 0, 0, 0, 0};
  private static Queue<Location> ripeTomato = new LinkedList<>();
  private static int unripeTomato = 0;
  private static int day = 0;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();
    int n = sc.nextInt();
    int h = sc.nextInt();
    int[][][] tomato = new int[h][n][m];

    // 주어진 입력값에 따라 3차원 배열 토마토 창고 초기화
    // 0이면 덜익은 토마토, 1이면 익은 토마토
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < m; k++) {
          tomato[i][j][k] = sc.nextInt();
          if (tomato[i][j][k] == 0) {
            unripeTomato++; // 덜익은 토마토 개수 증가
          } else if (tomato[i][j][k] == 1) {
            ripeTomato.add(new Location(i, j, k)); // bfs 탐색에 쓰일 익은 토마토 좌표를 큐에 저장
          }
        }
      }
    }

    // 덜익은 토마토가 있고, 익은 토마토의 좌표가 큐에 있으면 반복
    while (unripeTomato > 0 && !ripeTomato.isEmpty()) {
      int size = ripeTomato.size();

      // 익은 토마토의 좌표를 시작으로 탐색 시작
      // 현재 큐에 있는 익은 토마토의 좌표로부터 모든 탐색이 각각 이루어져야 하루가 지남
      for (int i = 0; i < size; i++) {
        Location location = ripeTomato.remove();
        int z = location.z;
        int y = location.y;
        int x = location.x;

        // 6가지 방향으로 탐색
        for (int j = 0; j < 6; j++) {
          int nz = z + rz[j];
          int ny = y + ry[j];
          int nx = x + rx[j];

          // 좌표 범위를 벗어나거나 탐색한 좌표가 덜익은 토마토가 아니라면 무시
          if (nz < 0 || ny < 0 || nx < 0 || nz >= h || ny >= n || nx >= m
              || tomato[nz][ny][nx] != 0) {
            continue;
          }

          unripeTomato--;
          tomato[nz][ny][nx] = 1;
          ripeTomato.add(new Location(nz, ny, nx));
        }
      }
      day++;
    }
    System.out.println(unripeTomato == 0 ? day : -1);
  }

  // 3차원 좌표
  static class Location {

    int z;
    int y;
    int x;

    Location(int z, int y, int x) {
      this.z = z;
      this.y = y;
      this.x = x;
    }

  }

}
