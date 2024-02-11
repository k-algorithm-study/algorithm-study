package org.example.kw99j10.baekjoon.search.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  먹을 것인가 먹힐 것인가 - Silver III
 */
public class Binary11 {
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); //a의 수
            int m = Integer.parseInt(st.nextToken()); //b의 수

            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(a);

            int[] b = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                b[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(b);

            count = 0;

            for (int j = a.length - 1; j >= 0; j--) {
                for (int value : b) {
                    if (a[j] > value) {
                        count += 1;
                    } else {
                        break;
                    }
                }
            }

            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}
