package org.example.kw99j10.baekjoon.greedy;

import java.util.Scanner;

/**
 * 설탕 배달 - Silver IV
 */
public class Greedy01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int count = -1; //정확하게 N킬로그램을 만들 수 없는 경우

        //5킬로그램 봉지를 기준으로 최소 개수를 탐색
        for (int i = 0; i <= 1000; i++) {
            for (int j = 0; j <= 1000; j++) {

                if (5 * i + 3 * j == n) {
                    count = i + j; //정확하게 N킬로그램을 만드는 경우
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
