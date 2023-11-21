package org.example.hcu55.baekjoon.sort;

import java.util.Scanner;

// 신입 사원, 실버 I
public class 신입사원 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();   // 테스트 케이스 개수

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();   // 지원자 수
            int count = 0;
            int work[] = new int[N + 1];
            for (int j = 0; j < N; j++) {
                int a = sc.nextInt();   // 겹치는 등수가 없으니 배열에 넣어줌
                int b = sc.nextInt();
                work[a] = b;
            }

            int rank = work[1];     // 서류 심사 1등의 면접 성적 순위
            count++;                // 서류 심사 1등은 뽑힘

            for (int j = 2; j <= N; j++) {
                if (work[j] < rank) {       // 서류 심사 1등보다 면접 성적 높은 사람 선발
                    rank = work[j];
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
