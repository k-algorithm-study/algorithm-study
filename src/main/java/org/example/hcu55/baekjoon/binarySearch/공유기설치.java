package org.example.hcu55.baekjoon.binarySearch;

import java.util.Arrays;
import java.util.Scanner;

// 공유기 설치, 골드 IV
public class 공유기설치 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();       // 집의 개수
        int C = sc.nextInt();       // 공유기의 개수
        int[] home = new int[N];

        for (int i = 0; i < N; i++) {
            home[i] = sc.nextInt();
        }

        Arrays.sort(home);   // 정렬

        int low = 0;
        int high = home[N - 1] - home[0];
        int max_Length = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            int start = home[0];
            int count = 1;      // 첫번째 집은 공유기 설치하니까 1부터 시작
            for (int i = 1; i < N; i++) {
                int distance = home[i] - start;   // 집마다 거리 체크
                if (distance >= mid) {   // 공유기 설치 가능한지 여부 체크
                    count++;
                    start = home[i]; // 설치후 시작 위치 초기화
                }
            }
            if (count >= C) {
                max_Length = mid;
                low = mid + 1;       // 설치 개수가 너무 많으면 low 증가
            } else {
                high = mid - 1;      // 설치 개수가 적으면 high 감소
            }
        }
        System.out.println(max_Length);
    }
}