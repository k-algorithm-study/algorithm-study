package org.example.hcu55.baekjoon.shortpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

// 최단 경로, 골드 IV
public class 최단경로 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        int start = sc.nextInt();    // 시작 정점

        // 인접 리스트 구현
        ArrayList<Element>[] adjList = new ArrayList[V + 1];
        for (int i = 1; i < V + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            adjList[u].add(new Element(v, w));
        }

        boolean[] check = new boolean[V + 1];

        int[] distance = new int[V + 1];
        int INF = 10 * (V - 1) + 1;         // INF는 항상 (간선 가중치의 최댓값) * (정점 개수 - 1) 보다 큰 값을 사용
        Arrays.fill(distance, INF);         // 배열 일괄 초기화 (INF값으로)
        distance[start] = 0;                // 시작 정점은 제외

        PriorityQueue<Element> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Element(start, 0));

        while (!priorityQueue.isEmpty()) {
            int current = priorityQueue.poll().index;

            if (check[current]) {
                check[current] = true;
            }

            // 다음 정점까지의 거리가 이미 기록된 해당 정점까지의 거리보다 더 짧으면 값을 갱신
            for (Element next : adjList[current]) {
                if (distance[next.index] > distance[current] + next.distance) {
                    distance[next.index] = distance[current] + next.distance;
                    // 거리 값이 갱신된 정점들을 우선순위 큐에 넣기
                    priorityQueue.offer(new Element(next.index, distance[next.index]));
                }
            }
        }

        // 출력
        for (int i = 1; i < V + 1; i++) {
            if (distance[i] == INF)
                System.out.println("INF");
            else
                System.out.println(distance[i]);
        }
    }

    // PriorityQueue 에서 정렬
    static class Element implements Comparable<Element> {
        int index;
        int distance;

        Element(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Element o) {
            return Integer.compare(this.distance, o.distance);
		/*
		 Integer.compare(int x, int y)
		 x == y ->  0 return
		 x < y  ->  -1 return
		 x > y  ->  1 return
		 */
        }
    }
}

