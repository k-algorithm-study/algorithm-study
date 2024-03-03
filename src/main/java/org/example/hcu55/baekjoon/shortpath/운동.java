package org.example.hcu55.baekjoon.shortpath;

import java.util.*;
import java.io.*;

// 운동, 골드 IV
public class 운동 {
    static final int INF = 10000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());       // 마을 수
        int E = Integer.parseInt(st.nextToken());       // 도로 수

        int[][] arr = new int[V + 1][V + 1];

        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i != j) {
                    arr[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[a][b] = c;
        }

        // 플로이드 와샬
        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        int result = INF;
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {

                if (i != j && arr[i][j] != INF && arr[j][i] != INF) {       // 자기 자신을 제외하고 서로 이동하는 경로가 존재
                    result = Math.min(result, arr[i][j] + arr[j][i]);       // 가장 작은 경로 찾기
                }
            }
        }

        if (result == INF) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}
