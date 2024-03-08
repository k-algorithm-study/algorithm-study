package org.example.kw99j10.baekjoon.sort;

import java.util.*;

/**
 *  중복 빼고 정렬하기 - Silver V
 */
public class Sort11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            if (list.contains(k)) {
                continue;
            }
            list.add(k);
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            sb.append(i).append(" ");
        }
        System.out.print(sb);
    }
}
