package org.example.hcu55.swea.D2;

import java.util.*;

public class 최빈수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            int testNum = sc.nextInt();
            int max = 0;
            int mode= 0;


            int[] score = new int[101];

            for (int i = 0; i < 1000; i++) {
                int num = sc.nextInt();     // 각 학생 점수 입력받기
                score[num] += 1;            // 각 수마다 횟수를 하나씩 증가하며 저장
            }

            for (int i = 0; i < score.length; i++) {
                if (score[i] >= max) {      // 현재 값이 최댓값보다 크거나 같으면
                    max = score[i];         // 최대값을 변경하고
                    mode = i;               // 그때 최빈값 수를 저장
                }
            }
            System.out.println("#" + testCase + " " + mode);
        }
    }
}
