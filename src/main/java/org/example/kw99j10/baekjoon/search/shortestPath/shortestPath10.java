package org.example.kw99j10.baekjoon.search.shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 타임머신 - Gold IV
 */
public class shortestPath10 {
    static class Node{
        int start;
        int end;
        int time;
        public Node(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }
    static int n;
    static ArrayList<Node>[] city;
    static long[] dist;
    static final int INF = (int) 10e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();

        city = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            city[i] = new ArrayList<>();
        }
        dist = new long[n + 1];
        Arrays.fill(dist, INF);//경로 초기화
        dist[1] = 0;

        //C = 0인 경우는 순간 이동을 하는 경우,
        // C < 0인 경우는 타임머신으로 시간을 되돌아가는 경우
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(); //출발지
            int b = sc.nextInt(); //목적지
            int c = sc.nextInt(); //걸린 시간
            city[a].add(new Node(a, b, c));
        }

        //최단 거리 업데이트
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (Node node : city[j]) {
                    if (dist[node.start] != INF) {
                        if (dist[node.end] > dist[node.start] + node.time) {
                            dist[node.end] = dist[node.start] + node.time;
                        }
                    }
                }
            }
        }
        //음수 사이클 확인
        for (int i = 1; i <= n; i++) {
            for (Node node : city[i]) {
                if (dist[node.start] != INF) {
                    if (dist[node.end] > dist[node.start] + node.time) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(dist[i] == INF ? -1 : dist[i]).append("\n");
        }
        System.out.print(sb);
    }
}
