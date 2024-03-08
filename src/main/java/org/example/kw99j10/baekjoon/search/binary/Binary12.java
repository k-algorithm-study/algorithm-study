package org.example.kw99j10.baekjoon.search.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 용돈 관리 - Silver II
 */
public class Binary12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] money = new int[n];
        int min = 1; //최소 인출 금액
        int max = 1; //최대 인출 금액

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            money[i] = Integer.parseInt(st.nextToken());
            min = Math.max(min, money[i]);
            max += money[i];
        }

        int mid;

        while (min <= max) {
            mid = (min + max) / 2;

            int sum = 0;
            int count = 1;
            for (int i = 0; i < n; i++) {
                sum += money[i];
                if (sum > mid) {
                    sum = money[i];
                    count++;
                }
            }

            if (count > m) {
                min = mid + 1;
            }
            else{
                max = mid - 1;
            }
        }
        System.out.println(min);
    }
}
