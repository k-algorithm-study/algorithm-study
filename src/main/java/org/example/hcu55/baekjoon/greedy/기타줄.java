package org.example.hcu55.baekjoon.greedy;

import java.util.Scanner;

// 기타줄, 실버 IV
public class 기타줄 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();       // 끊어진 기타줄 개수
        int M = sc.nextInt();       // 기타줄 브랜드 개수

        int minEach = 1000;
        int minPack = 1000;

        for (int i = 0; i < M; i++) {
            int pack = sc.nextInt();
            int each = sc.nextInt();

            if (pack < minPack) {
                minPack = pack;
            }
            if (each < minEach) {
                minEach = each;
            }
        }

        int minMoney = 0;
        int onlyPackage = 0;
        int onlyEach = 0;
        int mixPackEach = 0;

        if (N % 6 == 0) {                                         // 6으로 나누어떨어지면
            onlyPackage = minPack * (N / 6);                      // 오직 패키지로만 구매 가격
        } else {
            onlyPackage = minPack * ((N / 6) + 1);
        }
        onlyEach = minEach * N;                                   // 오직 낱개로만 구매 가격
        mixPackEach = (minPack * (N / 6)) + (minEach * (N % 6));  // 섞어서 구매

        minMoney = Math.min(onlyPackage, Math.min(onlyEach, mixPackEach));      // 최소 금액 찾기

        System.out.println(minMoney);
    }
}
