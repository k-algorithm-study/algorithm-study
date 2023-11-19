package org.example.hcu55.baekjoon.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 로프, 실버 IV
public class 로프 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Integer[] rope = new Integer[N];    // 로프 무게들 입력 받는 배열
        int max = 0;    // 최대 무게 저장 변수

        for (int i = 0; i < N; i++) {
            rope[i] = sc.nextInt();
        }
        Arrays.sort(rope, Collections.reverseOrder());  // 큰 수부터 정렬

        for (int i = 0; i < N; i++) {
            if (rope[i] * (i + 1) > max) {      // 최소 무게 * 순서가 들 수 있는 최대 무게임
                max = rope[i] * (i + 1);
            }
        }
        System.out.println(max);
    }
}
