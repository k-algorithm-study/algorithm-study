package org.example.kw99j10.baekjoon.search.shortestPath;

import java.util.Scanner;

/**
 * 경로 찾기 - Silver I
 * 플로이드 - 워셜 이용
 */
public class shortestPath03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //정점의 개수

        int[][] adj = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adj[i][j] = sc.nextInt(); //그래프의 인접 행렬
            }
        }

        //기존 경로가 0일 때 -> 해당 경로에 도달할 수 있는 간선이 있다면 1로 변경
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (adj[i][j] == 0) {
                        if (adj[i][k] == 1 && adj[k][j] == 1) {
                            adj[i][j] = 1;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
    }
}
