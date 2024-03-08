package org.example.kw99j10.baekjoon.search.shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 키 순서 - Gold IV
 * */
public class shortestPath11 {
    static int n, m;
    static int[][] student;
    static final int INF = 10001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        student = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                student[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            student[a][b] = 1;
        }

        //플로이드 - 워셜
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    student[i][j] = Math.min(student[i][j], student[i][k] + student[k][j]);
                }
            }
        }

        int[] count = new int[n + 1]; //앞뒤로 키 순서를 알 수 있는 학생의 수
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (student[i][j] != INF || student[j][i] != INF) {
                    count[i] += 1;
                }
            }
        }

        int know = 0;
        for (int i = 1; i <= n; i++) {
            if (count[i] == n - 1) {
                know += 1;
            }
        }
        System.out.println(know);
    }
}
