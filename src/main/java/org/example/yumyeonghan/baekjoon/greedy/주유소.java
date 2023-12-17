package org.example.yumyeonghan.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/13305
public class 주유소 {

  public static void main(String[] args) throws IOException {
    // 입력값 초기화
    Long answer = 0L;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    long[] dist = new long[n - 1]; // 거리
    long[] cost = new long[n]; // 가격
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    for (int i = 0; i < n - 1; i++) {
      dist[i] = Long.parseLong(stringTokenizer.nextToken());
    }
    stringTokenizer = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      cost[i] = Long.parseLong(stringTokenizer.nextToken());
    }

    // 그리디 계산
    // 현재 비용과 기준 비용을 비교해 가면서 더 싼 비용으로 초기화 후 계산
    Long baseCost = cost[0];
    for (int i = 0; i < n - 1; i++) {
      if (cost[i] < baseCost) {
        baseCost = cost[i];
      }
      answer += baseCost * dist[i];
    }
    System.out.println(answer);
  }

}
