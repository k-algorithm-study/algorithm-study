package org.example.kw99j10.baekjoon.greedy;

import java.util.Scanner;

public class Greedy14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int[] alpha = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            alpha[c - 65]++; //알파벳 개수
        }

        int odd = 0; //홀수 문자열의 개수
        for (int i = 0; i < 26; i++) {
            if (alpha[i] % 2 != 0) {
                odd++;
            }
        }

        String answer = "";
        if (odd > 1)
            answer = "I'm Sorry Hansoo"; //홀수 알파벳 개수

        else {
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < alpha[i] / 2; j++) {
                    tmp.append((char) (i + 65)); //앞
                }
            }
            answer += tmp;
            String reverse = tmp.reverse().toString(); //뒤

            tmp = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (alpha[i] % 2 == 1) {
                    tmp.append((char) (i + 65)); //홀수 알파벳 처리
                }
            }
            answer += tmp + reverse;
        }
        System.out.println(answer);
    }
}
