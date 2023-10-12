package org.example.hcu55.baekjoon.impl;

import java.util.Scanner;

//그룹 단어 체커, 실버 V
public class Impl01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count = 0;      // 그룹 단어의 개수

        for (int i = 0; i < N; i++) {
            if (check(sc.next()))
                count++;
        }
        System.out.println(count);
    }

    public static boolean check(String str) {
        boolean[] checkAlpha = new boolean[26];
        int prev = 0;       // 이전 문자

        for (int i = 0; i < str.length(); i++) {
            int now = str.charAt(i);    //현재 들어온 문자
            if (prev != now) {
                if (checkAlpha[now - 'a'] == false) {       // 현재 문자가 처음 나옴
                    checkAlpha[now - 'a'] = true;
                    prev = now;     // 이전 문자를 현재 문자로 바꾸기
                } else return false;  // 이전 문자와 다른 것이 들어왔지만 이미 앞에서 등장했던 문자 = 그룹 단어가 아님
            } else continue;
        }
        return true;
    }
}
