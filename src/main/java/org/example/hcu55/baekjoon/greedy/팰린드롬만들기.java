package org.example.hcu55.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 팰린드롬 만들기, 실버 III
public class 팰린드롬만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder left = new StringBuilder();
        StringBuilder mid = new StringBuilder();
        StringBuilder right = new StringBuilder();

        String str = br.readLine();
        int[] alpha = new int[26];

        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'A';
            alpha[index]++;
        }

        int oneCnt = 0;
        for (int i = 0; i < alpha.length; i++) {        // 홀수 개수 세기
            if (alpha[i] % 2 != 0) {
                oneCnt++;
            }
        }

        int num = 0;
        if (oneCnt > 1) {
            System.out.println("I'm Sorry Hansoo");
        } else {
            for (int i = 0; i < alpha.length; i++) {
                if (alpha[i] % 2 == 1) {                // 홀수 하나를 mid 값으로 보내기
                    num = i;
                    mid.append((char) (num + 65));
                    alpha[i]--;

                    while (alpha[i] != 0) {
                        left.append((char) (i + 65));   // 하나는 왼쪽
                        alpha[i]--;
                        right.append((char) (i + 65));  // 하나는 오른쪽
                        alpha[i]--;
                    }
                } else if (alpha[i] != 0) {             // 다 짝수일 때 양쪽에 분배
                    while (alpha[i] != 0) {
                        left.append((char) (i + 65));
                        alpha[i]--;
                        right.append((char) (i + 65));
                        alpha[i]--;
                    }
                }
            }
        }
        System.out.println(left.append(mid).append(right.reverse()));
    }
}
