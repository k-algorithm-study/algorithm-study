package org.example.kw99j10.baekjoon.greedy;

import java.util.*;

/**
 * 단어 수학 - Gold IV
 */
public class Greedy11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] alpha = new int[26];

        String[] tmp = new String[n];
        for (int i = 0; i < n; i++) {
            tmp[i] = sc.next(); //문자열을 입력 받음
        }

        //자릿수가 높을수록 높은 값 부여 -> 10의 배수
        for (int i = 0; i < n; i++) {
            int ans = (int) Math.pow(10, tmp[i].length() - 1);

            for (int j = 0; j < tmp[i].length(); j++) {
                alpha[(int) tmp[i].charAt(j) - 65] += ans; //알파벳 빈도 확인
                ans /= 10;
            }
        }
        Arrays.sort(alpha); //빈도만큼 정렬

        int idx = 9;
        int sum = 0;
        for (int i = alpha.length - 1; i >= 0; i--) {
            if (alpha[i] == 0) {
                break; //없는 알파벳
            }
            sum += alpha[i] * idx;
            idx -= 1;
        }
        System.out.println(sum);
    }
}
