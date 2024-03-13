package org.example.kw99j10.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *  트리의 지름 - Gold IV
 */
public class Graph13 {
    static class Node {
        int node;
        int weight;
        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    static int n, max;
    static ArrayList<Node>[] lists;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        lists = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            lists[a].add(new Node(b, c));
            lists[b].add(new Node(a, c));
        }

        for (int i = 1; i <= n; i++) {
            visit = new boolean[n + 1];
            visit[i] = true;
            dfs(i, 0);
        }
        System.out.println(max);
    }

    static void dfs(int current, int radius) {
        for (Node next : lists[current]) {
            if (!visit[next.node]) {
                visit[next.node] = true;
                dfs(next.node, radius + next.weight);
            }
            max = Math.max(radius, max);
        }
    }
}
