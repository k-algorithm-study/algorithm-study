package org.example.hcu55.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 수리공 항승, 실버 III
public class 수리공항승 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);       // 정렬

        double range = arr[0] - 0.5 + L;   // 최소 0.5이므로 0.5전부터 테이프 길이 계산
        int count = 1;                          // 카운트 개수

        for (int i = 1; i < arr.length; i++) {
            if (range < (arr[i] + 0.5)) {
                range = arr[i] - 0.5 + L;
                count++;
            }
        }
        System.out.println(count);
    }
}
