package org.example.yumyeonghan.baekjoon.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1697
public class 숨바꼭질 {

  static int n;
  static int k;
  static int[] isVisited = new int[100001];

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    k = sc.nextInt();
    if (n == k) {
      System.out.println(0);
    } else {
      bfs();
    }
  }

  static void bfs() {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(n);
    isVisited[n] = 1; // 도착지점으로 가는 시간 대신, 맨처음 1초라는 시간을 부여
    while (!queue.isEmpty()) {
      int tmp = queue.poll();
      // 갈수 있는 3가지 방향 모두 체크
      for (int i = 0; i < 3; i++) {
        int next = 0;
        if (i == 0) {
          next = tmp + 1;
        } else if (i == 1) {
          next = tmp - 1;
        } else {
          next = tmp * 2;
        }
        if (next == k) {
          System.out.println(isVisited[tmp]);
          return;
        }
        if (next >= 0 && next < isVisited.length && isVisited[next] == 0) {
          queue.add(next);
          isVisited[next] = isVisited[tmp] + 1;
        }
      }
    }
  }

}
