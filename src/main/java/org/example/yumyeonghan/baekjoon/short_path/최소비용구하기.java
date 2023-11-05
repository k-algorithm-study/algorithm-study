package org.example.yumyeonghan.baekjoon.short_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 가중치 개념이 있는 한 노드 기준의 최소 경로 값 -> Dijkstra (다익스트라)
 */

// https://www.acmicpc.net/problem/1916
public class 최소비용구하기 {

  static List<List<Edge>> adj;
  static int[] dist;
  static int n;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine()); // 도시의 개수
    int m = Integer.parseInt(br.readLine()); // 버스의 개수

    adj = new ArrayList<>();
    dist = new int[n + 1];
    Arrays.fill(dist, (int) 1e9);

    for (int i = 0; i <= n; i++) {
      adj.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      adj.get(s).add(new Edge(d, w));
    }
    st = new StringTokenizer(br.readLine());
    int start = Integer.parseInt(st.nextToken());
    int destination = Integer.parseInt(st.nextToken());
    System.out.println(dijkstra(start, destination));
  }

  static int dijkstra(int start, int destination) {
    PriorityQueue<Edge> que = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
    boolean isVisited[] = new boolean[n + 1];
    dist[start] = 0;
    que.offer(new Edge(start, 0));

    while (!que.isEmpty()) {
      Edge queNode = que.poll();
      int startNode = queNode.target;
      if (!isVisited[startNode]) {
        isVisited[startNode] = true;
        for (Edge edge : adj.get(startNode)) {
          if (!isVisited[edge.target] && dist[edge.target] > (dist[startNode] + edge.cost)) {
            dist[edge.target] = dist[startNode] + edge.cost;
            que.offer(new Edge(edge.target, dist[edge.target]));
          }
        }
      }
    }
    return dist[destination];
  }

  static class Edge {

    int target;
    int cost;

    Edge(int target, int cost) {
      this.target = target;
      this.cost = cost;
    }

  }

}
