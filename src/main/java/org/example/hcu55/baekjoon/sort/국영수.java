package org.example.hcu55.baekjoon.sort;

import java.util.Arrays;
import java.util.Scanner;

// 국영수, 실버 IV
public class 국영수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String[][] score = new String[N][4];

        for (int i = 0; i < N; i++) {   // 이름, 국어, 영어, 수학 점수 입력 받기
            for (int j = 0; j < 4; j++) {
                score[i][j] = sc.next();
            }
        }

        Arrays.sort(score, (o1, o2) -> {
            if (o1[1].equals(o2[1])) {                           // 국어 점수 같을 때
                if (o1[2].equals(o2[2])) {                       // 영어 점수 같을 때
                    if (o1[3].equals(o2[3])) {                   // 수학 점수 같을 때
                        return o1[0].compareTo(o2[0]);          // 이름 오름차순 정렬
                    }
                    return Integer.parseInt(o2[3]) - Integer.parseInt(o1[3]);   // 수학 점수 내림차순 정렬
                }
                return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);       // 영어 오름차순 정렬
            }
            return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);           // 국어 내림차순 정렬
        });

        for (String[] strings : score) {
            System.out.println(strings[0]);
        }
    }
}