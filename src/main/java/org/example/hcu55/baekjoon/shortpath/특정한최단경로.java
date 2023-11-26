package org.example.hcu55.baekjoon.shortpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

// 특정한 최단 경로, 골드 IV
public class 특정한최단경로 {
    private static int N;
    private static int E;
    private static ArrayList<Node>[] list;
    private static int[] distance;
    private static int INF = 2_000_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();   // 정점
        E = sc.nextInt();   // 간선
        list = new ArrayList[N + 1];    // 정점 인접리스트
        distance = new int[N + 1];      // 시작점과 다른 정점간의 최단경로

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {   // 초기화
            int a = sc.nextInt();       // 출발
            int b = sc.nextInt();       // 도착지
            int c = sc.nextInt();       // 가중치

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        int v1 = sc.nextInt();  // 지나야하는 정점
        int v2 = sc.nextInt();

        long answer1 = 0;        // 1->v1->v2->N
        answer1 += dijkstra(1, v1);
        answer1 += dijkstra(v1, v2);
        answer1 += dijkstra(v2, N);

        long answer2 = 0;       // 1->v2->v1->N
        answer2 += dijkstra(1, v2);
        answer2 += dijkstra(v2, v1);
        answer2 += dijkstra(v1, N);

        if (Math.min(answer1, answer2) >= INF) {
            System.out.println(-1);
            return;
        }
        System.out.println(Math.min(answer1, answer2));
    }

    public static int dijkstra(int start, int end) {
        distance = new int[N + 1];
        Arrays.fill(distance, INF);
        distance[start] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node nowNode = queue.poll();
            int nowVertex = nowNode.vertex;
            int nowWeight = nowNode.weight;

            if (distance[nowVertex] < nowWeight) {        // 현재 정점의 가중치가 크면 갱신할 필요가 없다.
                continue;
            }
            for (int i = 0; i < list[nowVertex].size(); i++) {     // 해당 정점과 연결된 것들 탐색
                int vertex2 = list[nowVertex].get(i).vertex;
                int weight2 = list[nowVertex].get(i).weight + nowWeight;

                if (distance[vertex2] > weight2) {        // 더 최단경로라면 갱신해준다.
                    distance[vertex2] = weight2;
                    queue.add(new Node(vertex2, weight2));
                }
            }
        }
        return distance[end];
    }

    public static class Node implements Comparable<Node> {
        int vertex;
        int weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}
