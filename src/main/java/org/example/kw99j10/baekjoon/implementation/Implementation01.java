package org.example.kw99j10.baekjoon.implementation;

import java.util.Scanner;

/**
 * 그룹 단어 체커 - Silver V
 */
public class Implementation01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //단어의 개수

        int count = 0; //그룹 단어의 개수 변수

        for (int i = 0; i < n; i++) {
            String s = sc.next(); //입력받은 단어

            boolean[] b = new boolean[26]; //알파벳 개수만큼의 배열 설정
            boolean k = true;

            //연속하지 않은 단어 체크
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                if (j > 0) {
                    if (s.charAt(j - 1) != s.charAt(j) && b[c - 97]) {
                        k = false;
                        break;
                    }
                }
                b[c - 97] = true; //알파벳 'a'의 아스키코드값 97
            }
            if (k) {
                count += 1;
            }
        }
        System.out.println(count);
    }
}
