package org.example.hcu55.baekjoon.graph;

import java.util.*;

// 최소 스패닝 트리, 골드 IV
public class 최소스패닝트리 {
    static int total;
    static List<Node>[] list;
    static boolean[] visited;

    static class Node implements Comparable<Node> {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        list = new ArrayList[V + 1];
        visited = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {       // 그래프 그려주기
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();

            list[from].add(new Node(to, cost));
            list[to].add(new Node(from, cost));
        }

        prim(1);
        System.out.println(total);
    }

    static void prim(int start) {
        Queue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int to = now.to;
            int weight = now.cost;

            if (visited[to]) continue;
            visited[to] = true;        // queue에서 뽑은 정점의 도착 지점 방문 처리(cost가 낮은 값을 선택)
            total += weight;

            for (Node next : list[to]) {
                if (!visited[next.to]) {
                    queue.add(next);
                }
            }
        }
    }
}
