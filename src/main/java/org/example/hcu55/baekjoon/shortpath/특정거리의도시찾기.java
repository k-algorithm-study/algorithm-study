package org.example.hcu55.baekjoon.shortpath;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 특정 거리의 도시 찾기, 실버 II
public class 특정거리의도시찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();       // 도시의 개수
        int M = sc.nextInt();       // 도로의 개수
        int K = sc.nextInt();       // 거리 정보
        int X = sc.nextInt();       // 출발 도시의 번호

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] d = new int[N + 1];       // 최단거리 저장 배열

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
            d[i] = -1;                  // 최단거리 -1로 초기화
        }

        for (int i = 0; i < M; i++) {   // 간선 정보 입력
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        // BFS
        d[X] = 0;       // 시작지점의 최단거리 값 0으로 초기화
        Queue<Integer> q = new LinkedList<>();
        q.offer(X);
        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < graph.get(now).size(); i++) {
                int nextNode = graph.get(now).get(i);
                if (d[nextNode] == -1) {
                    d[nextNode] = d[now] + 1;   // 도로의 거리가 1이기 때문에 이전 최단거리에 +1한 값 저장
                    q.offer(nextNode);
                }
            }
        }

        boolean check = false;
        for (int i = 1; i <= N; i++) {
            if (d[i] == K) {    // 최단 거리 K인 곳 찾기
                System.out.println(i);
                check = true;
            }
        }
        if (check == false)     // 최단거리가 k인 노드가 없다면 -1 출력
            System.out.println(-1);
    }
}
