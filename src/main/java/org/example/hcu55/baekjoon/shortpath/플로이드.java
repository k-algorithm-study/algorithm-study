package org.example.hcu55.baekjoon.shortpath;

import java.util.Scanner;

// 플로이드, 골드 IV
public class 플로이드 {

    static int[][] node;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();     // 도시의 개수
        int m = scan.nextInt();     // 버스의 개수
        node = new int[n + 1][n + 1];

        // 최대값 이상으로 값 초기화 자기 자신 노드 값은 0으로
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                node[i][j] = 100000001;
            }
            node[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            int start = scan.nextInt();
            int end = scan.nextInt();
            int cost = scan.nextInt();
            if (node[start][end] > cost)
                node[start][end] = cost;
        }

        // 플로이드-워샬
        for (int k = 1; k <= n; k++) {
            // 노드 i에서 j로 가는 경우.
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    // k번째 노드를 거쳐가는 비용이 기존 비용보다 더 작은 경우 갱신
                    if (node[i][j] > node[i][k] + node[k][j])
                        node[i][j] = node[i][k] + node[k][j];
                }
            }
        }

        // 출력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                //i -> j로 갈 수 없는 경우 0출력
                if (node[i][j] == 100000001)
                    System.out.print("0 ");
                else
                    System.out.print(node[i][j] + " ");
            }
            System.out.println();
        }
    }
}
