package org.example.kw99j10.baekjoon.search.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 사냥꾼 - Gold IV
 */
public class Binary13 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] s = new int[m]; //사대의 수
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(s);

        int[][] animal = new int[n][2]; //동물의 수
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            animal[i][0] = Integer.parseInt(st.nextToken());
            animal[i][1] = Integer.parseInt(st.nextToken());
        }


        int answer = 0; //잡을 수 있는 동물의 수
        for (int i = 0; i < n; i++) {
            int start = 0;
            int end = m - 1;
            while (start <= end) {
                int mid = (start + end) / 2;

                long distance = (Math.abs(s[mid] - animal[i][0]) + animal[i][1]);

                if (l >= distance) {
                    answer++; //l보다 작거나 같은 위치의 동물
                    break;
                }

                if (animal[i][0] >= s[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        System.out.println(answer);
    }
}
