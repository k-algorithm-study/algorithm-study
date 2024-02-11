package org.example.hcu55.baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

//단어 수학, 골드 IV
public class 단어수학 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String[] arr = new String[N];           // 들어오는 문자열 저장 배열
        int[] alpha = new int[26];              // 알파벳 배열

        for (int i = 0; i < N; i++) {           // 문자열 저장
            arr[i] = sc.next();
        }

        for (int i = 0; i < N; i++) {
            String str = arr[i];
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                alpha[c - 'A'] += (int) Math.pow(10, str.length() - 1 - j);
            }
        }

        Arrays.sort(alpha);

        int num = 9;
        int sum = 0;

        for (int i = alpha.length - 1; i >= 0; i--) {
            if (alpha[i] == 0) {
                break;
            }
            sum += alpha[i] * num;
            num--;
        }
        System.out.println(sum);
    }
}
