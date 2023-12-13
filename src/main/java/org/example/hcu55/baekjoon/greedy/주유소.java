package org.example.hcu55.baekjoon.greedy;

import java.util.Scanner;

// 주유소, 실버 III
public class 주유소 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long[] dist = new long[N - 1];	// 거리
        long[] cost = new long[N];	    // 비용

        for(int i = 0; i < N - 1; i++) {    // 거리 입력
            dist[i] = sc.nextLong();
        }

        for(int i = 0; i < N; i++) {    // 비용 입력
            cost[i] = sc.nextLong();
        }

        long minSum = 0;
        long minCost = cost[0];	    // 주유값 최소 변수

        for(int i = 0; i < N - 1; i++) {
            if(cost[i] < minCost) {
                minCost = cost[i];
            }
            minSum += (minCost * dist[i]);	    // 총 최소 비용 누적 합
        }
        System.out.println(minSum);
    }
}