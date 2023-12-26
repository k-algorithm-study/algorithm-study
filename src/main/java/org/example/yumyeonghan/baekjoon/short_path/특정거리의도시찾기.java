package org.example.yumyeonghan.baekjoon.short_path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/18352
public class 특정거리의도시찾기 {

  private static int n, m, k, x;
  private static int distanceInfo[];
  private static List<Integer>[] graph;
  private static List<Integer> answer;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();
    k = sc.nextInt();
    x = sc.nextInt();
    graph = new ArrayList[n + 1];
    answer = new ArrayList<>();

    // init graph (input value)
    for (int i = 1; i <= n; i++) {
      graph[i] = new ArrayList<>();
    }
    for (int i = 1; i <= m; i++) {
      int s = sc.nextInt();
      int e = sc.nextInt();
      graph[s].add(e);
    }

    // init distanceInfo (-1)
    distanceInfo = new int[n + 1];
    Arrays.fill(distanceInfo, -1);

    // search graph
    bfs(x);

    // output answer
    for (int i = 0; i <= n; i++) {
      if (distanceInfo[i] == k) {
        answer.add(i);
      }
    }
    if (answer.isEmpty()) {
      System.out.println("-1");
    } else {
      Collections.sort(answer);
      for (Integer i : answer) {
        System.out.println(i);
      }
    }

  }

  private static void bfs(int startCity) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(startCity);
    distanceInfo[startCity] += 1;
    while (!queue.isEmpty()) {
      int currentCity = queue.poll();
      for (int i = 0; i < graph[currentCity].size(); i++) {
        Integer nextCity = graph[currentCity].get(i);
        if (distanceInfo[nextCity] == -1) {
          distanceInfo[nextCity] = distanceInfo[currentCity] + 1;
          queue.add(nextCity);
        }
      }
    }
  }

}
