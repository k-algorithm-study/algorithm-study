package org.example.kw99j10.baekjoon.search.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  과자 나눠주기 - Silver II
 */
public class Binary15 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] chips = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            chips[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(chips);

        int start = 1;
        int end = chips[n - 1];

        while (start <= end) {
            int mid = (start + end) / 2;

            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += chips[i] / mid;
            }

            if (sum >= m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(end);
    }
}
