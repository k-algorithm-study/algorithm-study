package org.example.yumyeonghan.baekjoon.short_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11657
public class 타임머신 {

  private static final List<Bus> buses = new ArrayList<>();
  private static final long INF = Long.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    // init buses
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());
      buses.add(new Bus(start, end, weight));
    }

    long[] dist = new long[n + 1];
    Arrays.fill(dist, INF);
    dist[1] = 0;

    // 벨만-포드 알고리즘 (음수 가중치 처리)
    for (int i = 1; i <= n; i++) {
      for (Bus bus : buses) {
        if (dist[bus.start] == INF) {
          continue;
        }

        long tmp = dist[bus.start] + bus.weight;
        if (dist[bus.end] > tmp) {
          // 음의 사이클(무한하게 갱신됨)이 있으면 -1 출력 후, 종료
          if (i == n) {
            System.out.print("-1");
            return;
          }
          dist[bus.end] = tmp;
        }
      }
    }

    // output answer
    StringBuilder sb = new StringBuilder();
    for (int i = 2; i <= n; i++) {
      sb.append(dist[i] == INF ? "-1" : dist[i]).append("\n");
    }
    System.out.print(sb);
  }

  private static class Bus {

    int start, end;
    int weight;

    public Bus(int start, int end, int weight) {
      this.start = start;
      this.end = end;
      this.weight = weight;
    }
  }

}
