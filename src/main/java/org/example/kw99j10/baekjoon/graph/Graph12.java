package org.example.kw99j10.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 네트워크 연결 - Gold IV
 */
public class Graph12 {
    static int n, m;

    static class Graph {
        int v;
        int cost;

        public Graph(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    static ArrayList<Graph>[] lists;
    static boolean[] visit; //방문 확인 배열
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        lists = new ArrayList[n + 1];
        visit = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            lists[a].add(new Graph(b, c));
            lists[b].add(new Graph(a, c));
        }
        mst();
        System.out.println(min);
    }
    static void mst() {
        //최소 비용 순 정렬
        PriorityQueue<Graph> queue = new PriorityQueue<>(Comparator.comparingInt((o -> o.cost)));
        queue.add(new Graph(1, 0));

        while (!queue.isEmpty()) {
            Graph current = queue.poll();

            int vertex = current.v;
            int weight = current.cost;

            if (!visit[vertex]) {
                visit[vertex] = true;
                min += weight;

                for (Graph next : lists[vertex]) {
                    if (!visit[next.v]) {
                        queue.add(next);
                    }
                }
            }
        }
    }
}
