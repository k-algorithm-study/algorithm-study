package org.example.kw99j10.baekjoon.search.binary;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 암기왕 - Silver IV
 */
public class Binary09 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            int[] book1 = new int[n]; //수첩 1
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                book1[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(book1);

            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int tmp = Integer.parseInt(st.nextToken());

                int start = 0;
                int mid;
                int end = n - 1;

                while (start <= end) {
                    mid = (start + end) / 2;

                    if (tmp == book1[mid]) {
                        tmp = start;
                        break;
                    }

                    else if (tmp > book1[mid]) {
                        start = mid + 1;
                    }
                    else{
                        end = mid - 1;
                    }
                }
                sb.append(tmp == start ? 1 : 0).append("\n");
            }
        }
        System.out.print(sb);
    }
}
