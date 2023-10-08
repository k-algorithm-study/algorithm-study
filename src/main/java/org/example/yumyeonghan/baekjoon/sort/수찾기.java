package org.example.yumyeonghan.baekjoon.sort;


import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1920
public class 수찾기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arrN = new int[n];
        for (int i = 0; i < n; i++) {
            arrN[i] = scanner.nextInt();
        }

        Arrays.sort(arrN); //이진 탐색을 위한 정렬

        int m = scanner.nextInt();
        int[] arrM = new int[m];
        for (int i = 0; i < m; i++) {
            arrM[i] = scanner.nextInt();
        }

        for (int v : arrM) {
            if (Arrays.binarySearch(arrN, v) >= 0) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }

}
