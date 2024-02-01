package org.example.hcu55.baekjoon.shortpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 타임머신, 골드 IV
public class 타임머신 {
    static int N;       // 도시 개수
    static int M;       // 노선 수
    static Bus[] buses;
    static long[] dist;
    static long INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        buses = new Bus[M];
        dist = new long[N + 1];
        Arrays.fill(dist, INF);         // 최단 거리 테이블 초기화

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            buses[i] = new Bus(from, to, time);
        }

        if (bellmanFord(1)) {       // 음수 순환 존재하면 -1 출력
            System.out.println(-1);
        } else {
            for (int i = 2; i < N + 1; i++) {       // 1번 노드를 제외한 다른 모든 노드로 가기 위한 최단거리 출력
                if (dist[i] == INF) {               // 도달할 수 없으면 -1
                    System.out.println("-1");
                } else {                            // 최단 거리 출력
                    System.out.println(dist[i]);
                }
            }
        }
    }

    static boolean bellmanFord(int start) {
        dist[start] = 0;

        for (int i = 1; i < N + 1; i++) {
            for (int j = 0; j < M; j++) {
                int cur = buses[j].from;
                int next = buses[j].to;
                int cost = buses[j].time;

                if (dist[cur] == INF) {
                    continue;
                }

                if (dist[next] > (dist[cur] + cost)) {      // 현재 간선을 거쳐서 다른 노드로 이동하는 거리가 짧은 경우
                    dist[next] = dist[cur] + cost;

                    if (i == N) {       // n번째 라운드에서 값이 갱신된다면 음수 순환 존재
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static class Bus {
        int from;
        int to;
        int time;

        Bus(int from, int to, int time) {
            this.from = from;
            this.to = to;
            this.time = time;
        }
    }
}

