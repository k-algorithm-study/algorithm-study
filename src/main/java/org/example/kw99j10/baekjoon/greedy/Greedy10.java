package org.example.kw99j10.baekjoon.greedy;

import java.util.Scanner;

/**
 * 뒤집기 - Silver V
 */
public class Greedy10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        int zeroCount = 0; //연속된 0의 개수
        int oneCount = 0; //연속된 1의 개수

        //연속된 ' '의 개수 = 문자열을 뒤집어야 하는 횟수

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (i == 0) {
                if (c == '0') {
                    zeroCount += 1;
                } else {
                    oneCount += 1;
                }
            } else {
                //현재 값이 이전 문자와 같지 않다면 ex) 01
                if (c != s.charAt(i - 1)) {
                    if (c == '0') {
                        zeroCount += 1;
                    } else {
                        oneCount += 1;
                    }
                }
            }
        }
        int min = Math.min(zeroCount, oneCount);
        System.out.println(min);
    }
}
