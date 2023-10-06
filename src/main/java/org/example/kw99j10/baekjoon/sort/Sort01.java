package org.example.kw99j10.baekjoon.sort;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 수 찾기, Silver IV
 */
public class Sort01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        var h = new HashSet<Integer>();

        for (int i = 0; i < n; i++) {
            h.add(sc.nextInt());
        }

        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {

            int k = sc.nextInt();

            if (h.contains(k)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
