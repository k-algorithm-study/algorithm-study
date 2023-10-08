package org.example.yumyeonghan.baekjoon.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1316
public class 그룹단어체커 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int answer = 0;
        for (int i = 0; i < num; i++) {
            if (check(scanner.next())) {
                answer += 1;
            }
        }
        System.out.println(answer);
    }

    private static boolean check(String str) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char base = str.charAt(i);
            if (list.contains(base) && base != str.charAt(i - 1)) {
                return false;
            }
            list.add(base);
        }
        return true;
    }

}
