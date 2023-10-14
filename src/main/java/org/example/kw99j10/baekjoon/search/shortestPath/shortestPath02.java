package org.example.kw99j10.baekjoon.search.shortestPath;

import java.util.Scanner;

/**
 *  플로이드 - Gold IV
 *  플로이드 워셜 - 모든 노드에서 다른 모드로의 최단 경로를 구하는 알고리즘
 *  경유점이 존재함
 */
public class shortestPath02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //n개의 도시
        int m = sc.nextInt(); //m개의 버스

        int[][] arr = new int[n + 1][n + 1];

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                arr[i][j] = 10000001;
            }
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(); //시작 도시
            int b = sc.nextInt(); //도착 도시
            int c = sc.nextInt(); //비용

            arr[a][b] = Math.min(arr[a][b], c); //도시 간 최소 비용
        }

        for (int i = 1; i <= n; i++) {
            arr[i][i] = 0; //자기 자신 노드 0으로 초기화
        }
        //플로이드 - 워셜 알고리즘
        for (int k = 1; k <= n; k++) { //경유지 노드
            for (int i = 1; i <= n; i++) { //출발 노드
                for (int j = 1; j <= n; j++) { //도착 노드
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[i][j] >=10000001) {
                    arr[i][j] = 0;
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
