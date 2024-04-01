package org.example.kw99j10.baekjoon.search.shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  서강그라운드 - Gold IV
 */
public class shortestPath13 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(map[i], 9999999);
        }
        for (int i = 1; i <= n; i++) {
            map[i][i] = 0;
        }

        int[] item = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a][b] = c;
            map[b][a] = c;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            int sum = item[i];
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }
                if (m >= map[i][j]) {
                    sum += item[j];
                }
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}
