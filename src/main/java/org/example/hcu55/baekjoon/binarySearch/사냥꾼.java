package org.example.hcu55.baekjoon.binarySearch;

import java.io.*;
import java.util.*;

// 사냥꾼, 골드 IV
public class 사냥꾼 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());       // 사대 수
        int N = Integer.parseInt(st.nextToken());       // 동물 수
        long L = Long.parseLong(st.nextToken());        // 사정거리

        int[] sadae = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            sadae[i] = Integer.parseInt(st.nextToken());  // 사대 위치 입력
        }

        int[][] animal = new int[N][2];
        for (int i = 0; i < N; i++) {                   // 동물 위치 입력
            st = new StringTokenizer(br.readLine());
            animal[i][0] = Integer.parseInt(st.nextToken());
            animal[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sadae);           // 사대 오름차순 정렬
        int result = 0;

        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = M - 1;

            while (left <= right) {
                int mid = (left + right) / 2;
                long distance = Math.abs(sadae[mid] - animal[i][0]) + animal[i][1];

                if (distance <= L) {
                    result++;
                    break;
                }

                if (animal[i][0] < sadae[mid]) {    // 사대 위치가 더 크다면
                    right = mid - 1;                // 작은 사대로 위치
                } else {
                    left = mid + 1;                 // 다음 큰 사대 위치
                }
            }
        }
        System.out.println(result);
    }
}
