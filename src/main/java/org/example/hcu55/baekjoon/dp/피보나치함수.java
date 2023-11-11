package org.example.hcu55.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 피보나치 함수, 실버 III
public class 피보나치함수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   // Scanner쓰면 시간 초과가 남
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] fibonacci0count = new int[41];
            int[] fibonacci1count = new int[41];
            fibonacci0count[0] = 1;     // 피보나치에서 0일때 0의 개수
            fibonacci0count[1] = 0;     // 피보나치에서 0일때 1의 개수
            fibonacci1count[0] = 0;     // 피보나치에서 1일때 0의 개수
            fibonacci1count[1] = 1;     // 피보나치에서 1일때 1의 개수

            for (int k = 2; k <= N; k++) {
                fibonacci0count[k] = fibonacci0count[k - 1] + fibonacci0count[k - 2];
                fibonacci1count[k] = fibonacci1count[k - 1] + fibonacci1count[k - 2];
            }
            System.out.println(fibonacci0count[N] + " " + fibonacci1count[N]);
        }
    }
}
