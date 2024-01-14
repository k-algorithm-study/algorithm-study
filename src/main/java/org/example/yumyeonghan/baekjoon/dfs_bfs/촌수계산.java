package org.example.yumyeonghan.baekjoon.dfs_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/2644
public class 촌수계산 {

  private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  private static int[] dist;
  private static boolean[] visited;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(); // 전체 사람 수
    dist = new int[n + 1];
    visited = new boolean[n + 1];

    int person1 = sc.nextInt();
    int person2 = sc.nextInt();

    for (int i = 0; i <= n; ++i) {
      graph.add(new ArrayList<>());
    }

    int count = sc.nextInt();
    for (int i = 0; i < count; ++i) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      graph.get(a).add(b);
      graph.get(b).add(a);
    }
    System.out.println(bfs(person1, person2));
  }

  public static int bfs(int person1, int person2) {
    Queue<Integer> q = new LinkedList<>();
    dist[person1] = 0;
    visited[person1] = true;

    q.offer(person1);
    while (!q.isEmpty()) {
      int cur = q.poll();
      for (int next : graph.get(cur)) {
        if (!visited[next]) {
          dist[next] = dist[cur] + 1;
          if (next == person2) {
            return dist[next];
          }
          q.offer(next);
          visited[next] = true;
        }
      }
    }
    return -1;
  }

}
