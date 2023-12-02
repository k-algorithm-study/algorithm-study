package org.example.kw99j10.baekjoon.search.binary;

import java.util.Scanner;

/**
 * 게임 - Silver III
 */

public class Binary06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt(); //게임 횟수
        int y = sc.nextInt(); //이긴 게임

        int z = getPercent(x, y); //형택이의 승률

        //z가 절대 변하지 않음: 형택이의 승률이 99이상
        if (z >= 99) {
            System.out.println(-1);
            return;
        }


        //게임 횟수 범위: 1 ~ 10억
        int start = 1;
        int end = (int) 1e9;

        while (start <= end) {
            int mid = (start + end) / 2;

            //z가 변해야 함 -> 경기마다 승리해야 함
            int score = getPercent(x + mid, y + mid);

            if (z >= score) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        System.out.println(start);
    }

    private static int getPercent(int x, double y) {
        return (int) ((long) y * 100 / x);
    }
}
