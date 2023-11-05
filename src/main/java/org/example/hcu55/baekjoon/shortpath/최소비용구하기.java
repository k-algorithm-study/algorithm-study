package org.example.hcu55.baekjoon.shortpath;

import java.util.*;

// 최소비용 구하기, 골드 V
// https://loosie.tistory.com/166
public class 최소비용구하기 {
    static List<Node>[] list;
    static int[] distance;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        list = new ArrayList[N + 1];    // 리스트
        distance = new int[N + 1];      // 거리 배열
        check = new boolean[N + 1];     // 접근했는지 확인 배

        Arrays.fill(distance, Integer.MAX_VALUE);   // 초기값 세팅

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();

            list[from].add(new Node(to, cost));
        }

        int start = sc.nextInt();   // 출발 위치
        int destination = sc.nextInt(); // 도착 위치

        dijkstra(start);
        System.out.println(distance[destination]);
    }

    static void dijkstra(int start) {
        Queue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(start, 0));
        distance[start] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (check[node.to])
                continue;

            check[node.to] = true;
            for (Node next : list[node.to]) {
                if (distance[next.to] >= distance[node.to] + next.cost) {
                    distance[next.to] = distance[node.to] + next.cost;
                    queue.add(new Node(next.to, distance[next.to]));
                }
            }
        }
    }

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
}
