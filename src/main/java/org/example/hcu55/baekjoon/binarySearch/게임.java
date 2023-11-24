package org.example.hcu55.baekjoon.binarySearch;

import java.util.Scanner;

// 게임, 실버 III
public class 게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long X = sc.nextInt();  // 판수
        long Y = sc.nextInt();  // 승수
        long Z = 100 * Y / X;   // 승률

        if (Z >= 99) {          // 승률 99퍼 이상은 승률이 바뀔수가 없음
            System.out.println(-1);
            return;
        }
        long start = 1;
        long end = (int) X;

        while (start < end) {   // 이진 탐색으로 최소 판수를 찾음
            long mid = (start + end) / 2;
            long winning_rate = 100 * (Y + mid) / (X + mid);

            if (winning_rate > Z) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(end);
    }
}