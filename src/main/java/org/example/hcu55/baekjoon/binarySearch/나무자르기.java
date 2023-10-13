package org.example.hcu55.baekjoon.binarySearch;

import java.util.Scanner;

// 나무 자르기, 실버 II
public class 나무자르기 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   // 나무 수
        int M = sc.nextInt();   // 원하는 나무 길이

        int[] tree = new int[N];

        int min = 0;
        int mid = 0;
        int max = 0;

        for (int i = 0; i < N; i++) {
            tree[i] = sc.nextInt();
            if (max < tree[i]) {        // 최고 나무 높이 갱신
                max = tree[i];
            }
        }
        // 이진 탐색
        while (min < max) {
            mid = (min + max) / 2;
            long sum = 0;
            for (int treeHeight : tree) {
                if (treeHeight - mid > 0) {     // 자른 나무 길이 양수인 경우만 구함
                    sum += (treeHeight - mid);
                }
            }
            if (sum < M) {      // 지금 원하는 길이보다 낮은 경우
                max = mid;      // max를 mid 값으로 변경
            } else {              // 원하는 길이 보다 높은 경우
                min = mid + 1;  // min값을 mid+1로 증가 시킴
            }
        }
        System.out.println(min - 1);
    }
}
