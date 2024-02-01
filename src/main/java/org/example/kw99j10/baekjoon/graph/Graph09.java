package org.example.kw99j10.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 최소 스패닝 트리 - Gold IV
 */
public class Graph09 {
    static class Graph {
        int node; //정점
        int weight; //가중치

        public Graph(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    static int v, e; //정점, 간선
    static ArrayList<Graph>[] lists;
    static boolean[] visit; //방문 확인 배열
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        lists = new ArrayList[v + 1];
        visit = new boolean[v + 1];
        for (int i = 1; i <= v; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            //a -> b 경로 & c: 가중치
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            lists[a].add(new Graph(b, c));
            lists[b].add(new Graph(a, c));
        }
        mst(); //최소 신장 트리 (가장 가중치가 적은 연결 트리를 구함)
        System.out.println(min); //최소 가중치
    }
    private static void mst() {
        PriorityQueue<Graph> queue = new PriorityQueue<>(Comparator.comparingInt((o -> o.weight)));

        //시작 할 정점(K) 초기화
        queue.add(new Graph(1, 0));

        //프림 알고리즘
        while (!queue.isEmpty()) {
            Graph graph = queue.poll();

            int current = graph.node;
            int cost = graph.weight;

            if (!visit[current]) {
                visit[current] = true;
                min += cost;

                for (Graph next : lists[current]) {
                    if (!visit[next.node]) {
                        queue.add(next);
                    }
                }
            }
        }
    }
}
