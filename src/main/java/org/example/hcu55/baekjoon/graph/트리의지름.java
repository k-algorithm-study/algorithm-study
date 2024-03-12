package org.example.hcu55.baekjoon.graph;

import java.util.*;
import java.io.*;

// 트리의 지름, 골드 IV
public class 트리의지름 {
    static List<Node>[] list;
    static boolean[] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());             // 노드의 개수
        list = new ArrayList[n + 1];

        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to, cost));
            list[to].add(new Node(from, cost));
        }

        for (int i = 1; i < n + 1; i++) {
            visited = new boolean[n + 1];
            dfs(i, 0);
        }

        System.out.println(result);
    }

    public static void dfs(int x, int cost) {

        visited[x] = true;      // 방문처리

        for (int i = 0; i < list[x].size(); i++) {
            Node node = list[x].get(i);

            if (!visited[node.edge]) {
                visited[node.edge] = true;
                dfs(node.edge, cost + node.cost);
            }
        }

        if (result < cost) {
            result = cost;
        }
    }

    public static class Node {
        int edge;
        int cost;

        public Node(int edge, int cost) {
            this.edge = edge;
            this.cost = cost;
        }
    }
}
