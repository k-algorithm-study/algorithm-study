package org.example.hcu55.baekjoon.impl;

import java.util.Scanner;

// 크로아티아 알파벳, 실버 V
public class 크로아티아알파벳 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        String str = sc.next();

        for (String s : croatia) {
            if (str.contains(s)) {
                str = str.replace(s, "X");
            }
        }
        System.out.println(str.length());
    }
}
