package org.example.kw99j10.baekjoon.search.shortestPath;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 최단 경로 - Gold IV
 * 다익스트라 - 하나의 노드에서 출발하여 다른 노드로의 최단 경로를 구하는 알고리즘
 */
public class shortestPath01 {
    static class Node {
        int v; //목적지 노드
        int cost; //목적지 노드 까지 걸리는 비용(가중치)

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    static ArrayList<Node>[] lists; //노드 정보를 담을 리스트

    static boolean[] visit; //방문 확인 배열

    static int[] distance; //노드 간 최단 거리를 담는 배열

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt(); //정점의 개수
        int E = sc.nextInt(); //간선의 개수
        int K = sc.nextInt(); //시작 정점의 번호

        //각 배열 선언 및 초기화
        lists = new ArrayList[V + 1];
        visit = new boolean[V + 1];
        distance = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            lists[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            //u에서 v까지의 가중치 w
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            lists[u].add(new Node(v, w));
        }

        dijkstra(K);

        //거리가 초기화 되었으면(u에서 v까지의 거리가 있으면)해당 거리를 출력 아닐 시 "INF" 출력
        for (int i = 1; i < distance.length; i++) {
            System.out.println(distance[i] != Integer.MAX_VALUE ? distance[i] : "INF");
        }
    }

    static void dijkstra(int k) {
        //최단 거리를 구하기 위함 & 중복 방지
        PriorityQueue<Node> queue = new PriorityQueue<>((Comparator.comparingInt(o -> o.cost)));

        //시작 할 정점(K) 초기화
        queue.add(new Node(k, 0));
        visit[k] = true;
        distance[k] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (!visit[node.v]) {
                visit[node.v] = true; //방문한 노드가 아니라면 방문
            }
            for (Node list : lists[node.v]) {
                if (!visit[list.v] && distance[list.v] > node.cost + list.cost) {
                    distance[list.v] = node.cost + list.cost;
                    queue.add(new Node(list.v, distance[list.v]));
                }
            }
        }
    }
}
