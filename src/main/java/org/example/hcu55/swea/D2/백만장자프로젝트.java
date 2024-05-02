package org.example.hcu55.swea.D2;

import java.util.*;

public class 백만장자프로젝트 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int testCase = 0; testCase < T; testCase++) {
            int N = sc.nextInt();
            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {       // N개 매매가 입력받기
                arr[i] = sc.nextInt();
            }

            long sum = 0;
            int max = arr[N - 1];               // 마지막 값을 최댓값이라고 가정

            for (int i = N - 1; i >= 0; i--) {  // 뒤에서부터 하나씩 비교할 것임
                if (arr[i] > max) {             // 최대값보다 현재 값이 크다면 구매하면 안됨 최댓값 갱신
                    max = arr[i];
                } else {
                    sum += max - arr[i];
                }
            }

            System.out.println("#" + (testCase + 1) + " " + sum);
        }
    }
}
