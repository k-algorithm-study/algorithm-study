package org.example.hcu55.baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 숨바꼭질 3, 골드 V
public class 숨바꼭질3 {
    static int N, K;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    static int max = 100000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[max + 1];
        bfs();
        System.out.println(min);
    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(N, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            visited[now.x] = true;
            if (now.x == K) {
                min = Math.min(min, now.time);
            }

            if (now.x * 2 <= max && !visited[now.x * 2]) {
                queue.add(new Node(now.x * 2, now.time));
            }
            if (now.x + 1 <= max && !visited[now.x + 1]) {
                queue.add(new Node(now.x + 1, now.time + 1));
            }
            if (now.x - 1 >= 0 && !visited[now.x - 1]) {
                queue.add(new Node(now.x - 1, now.time + 1));
            }
        }
    }

    public static class Node {
        int x;
        int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}
