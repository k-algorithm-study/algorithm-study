package org.example.hcu55.baekjoon.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 이분 그래프, 골드 IV
public class 이분그래프 {
    static int V, E;
    static ArrayList<Integer>[] graph;
    static int visited[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(st.nextToken());

        for (int tc = 0; tc < testCase; tc++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            visited = new int[V + 1];
            graph = new ArrayList[V + 1];

            for (int i = 0; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int p1 = Integer.parseInt(st.nextToken());
                int p2 = Integer.parseInt(st.nextToken());

                graph[p1].add(p2);
                graph[p2].add(p1);
            }
            bfs();
        }
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= V; i++) {
            if (visited[i] == 0) {
                queue.add(i);
                visited[i] = 1;
            }

            while (!queue.isEmpty()) {
                int now = queue.poll();

                for (int j = 0; j < graph[now].size(); j++) {
                    if (visited[graph[now].get(j)] == 0) {
                        queue.add(graph[now].get(j));
                    }

                    if (visited[graph[now].get(j)] == visited[now]) {
                        System.out.println("NO");
                        return;
                    }

                    if (visited[now] == 1 && visited[graph[now].get(j)] == 0) {
                        visited[graph[now].get(j)] = 2;
                    } else if (visited[now] == 2 && visited[graph[now].get(j)] == 0) {
                        visited[graph[now].get(j)] = 1;
                    }
                }
            }
        }
        System.out.println("YES");
    }
}