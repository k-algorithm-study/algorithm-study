package org.example.kw99j10.baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 기타줄 - Silver IV
 */
public class Greedy12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] total = new int[m];
        int[] piece = new int[m];
        for (int i = 0; i < m; i++) {
            total[i] = sc.nextInt(); //패키지
            piece[i] = sc.nextInt(); //낱개
        }
        Arrays.sort(total);
        Arrays.sort(piece);

        int minPackage = total[0] * (n / 6); //최소 패키지값
        if (n % 6 != 0) {
            minPackage += Math.min(total[0], (n % 6) * piece[0]);
        }

        int minPiece = piece[0] * n; //최소 낱개가 곧 최솟값

        System.out.println(Math.min(minPackage, minPiece));
    }
}
