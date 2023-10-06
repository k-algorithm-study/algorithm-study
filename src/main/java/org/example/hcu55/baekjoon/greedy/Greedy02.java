package org.example.hcu55.baekjoon.greedy;

import java.util.Scanner;

//동전 0, 실버 IV
public class Greedy02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();       // 동전 종류
        int K = sc.nextInt();       // 금액
        int count = 0;
        int[] coin = new int[N];

        for (int i = 0; i < N; i++) {       // 얼마짜리 동전인지 입력받음
            coin[i] = sc.nextInt();
        }

        for (int i = N - 1; i >= 0; i--) {  // 큰 돈 부터 나눠보기
            if (K >= coin[i]) {
                count += (K / coin[i]);     // i번째 동전이 몇 개 쓰이나 보고 count에 개수 저장
                K = K % coin[i];            // i번째 동전을 쓰고 나머지 값을 다시 K에 넣어서 마지막 코인까지 반복
            }
        }
        System.out.println(count);
    }
}
