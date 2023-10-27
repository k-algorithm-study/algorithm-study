package org.example.kw99j10.baekjoon.implementation;

import java.util.Scanner;

/**
 * 크로아니타 알파벳 - Silver V
 */
public class Implementation04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String s = sc.next(); //입력

        /**
         * 크로아티아 알파벳으로 치환 c=, c-, dz=, d-, lj, nj, s=, z= -> 8개
         */
        s = s.replace("c=", "A");
        s = s.replace("c-", "B");
        s = s.replace("dz=", "C");
        s = s.replace("d-", "D");
        s = s.replace("lj", "E");
        s = s.replace("nj", "F");
        s = s.replace("s=", "G");
        s = s.replace("z=", "H");

        System.out.println(s.length());
    }
}
