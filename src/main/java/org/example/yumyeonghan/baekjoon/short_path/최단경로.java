package org.example.yumyeonghan.baekjoon.short_path;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 가중치 개념이 없는 단순 최소 경로 문제 -> BFS
 * 가중치 개념이 있는 한 노드 기준의 최소 경로 값 -> Dijkstra (다익스트라)
 * 가중치 개념이 있는 모든 노드기 준의 최소 경로 값 -> Floyd Warshall(플로이드 와샬)
 */

// https://www.acmicpc.net/problem/1753
public class 최단경로 {

    static List<Edge>[] adj;
    static int[] dist;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vertex = scanner.nextInt();
        int e = scanner.nextInt();
        int k = scanner.nextInt();

        // 1. 거리 배열 초기화
        dist = new int[vertex + 1];
        for (int i = 1; i <= vertex; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        // 2. 인접 리스트 초기화
        adj = new ArrayList[vertex + 1];
        for (int i = 1; i <= vertex; i++) {
            adj[i] = new ArrayList<>();
        }

        // 3. 방향 간선 입력
        for (int i = 0; i < e; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            adj[u].add(new Edge(v, w));
        }

        // 4. 다익스트라 실행
        dijkstra(k);

        // 5. 출력
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= vertex; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                stringBuilder.append("INF" + "\n");
            } else {
                stringBuilder.append(dist[i] + "\n");
            }
        }
        System.out.println(stringBuilder);
    }

    private static void dijkstra(int k) {
        // 1. 출발지 비용은 0, 우선 순위 큐에 넣고 시작
        PriorityQueue<Edge> q = new PriorityQueue<>();
        dist[k] = 0;
        q.add(new Edge(k, 0));
        while (!q.isEmpty()) {
            Edge currentEdge = q.poll();

            // 2. 현재 경로보다 더 큰 비용이 들면 무시
            if (currentEdge.cost > dist[currentEdge.target]) {
                continue;
            }

            // 3. 현재 위치에 연결된 간선 탐색
            int size = adj[currentEdge.target].size();
            for (int i = 0; i < size; i++) {
                Edge nextEdge = adj[currentEdge.target].get(i);

                // 4. 비용이 더 적을 때 갱신 및 큐에 저장
                if (dist[nextEdge.target] > currentEdge.cost + nextEdge.cost) {
                    dist[nextEdge.target] = currentEdge.cost + nextEdge.cost;
                    q.add(new Edge(nextEdge.target, dist[nextEdge.target]));
                }
            }

        }
    }

    // 우선 순위 큐에서 정렬에 사용 될 Comparable interface 구현
    static class Edge implements Comparable<Edge> {

        int target;
        int cost;

        Edge(int target, int cost) {
            this.target = target;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }

    }

}
