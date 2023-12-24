package org.example.yumyeonghan.baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11725
public class 트리의부모찾기 {

  private static List<List<Integer>> graph;
  private static int[] answer;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    answer = new int[n + 1];
    graph = new ArrayList<>();

    // input value & init graph
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }
    for (int count = 0; count < n - 1; count++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      graph.get(from).add(to);
      graph.get(to).add(from);
    }

    // search graph
    bfs();

    // output answer
    for (int node = 2; node <= n; node++) {
      System.out.println(answer[node]);
    }
  }

  private static void bfs() {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(1);
    while (!queue.isEmpty()) {
      int node = queue.poll();
      for (int index = 0; index < graph.get(node).size(); index++) {
        int nextNode = graph.get(node).get(index);
        if (answer[nextNode] == 0) {
          answer[nextNode] = node;
          queue.add(nextNode);
        }
      }
    }
  }

}
