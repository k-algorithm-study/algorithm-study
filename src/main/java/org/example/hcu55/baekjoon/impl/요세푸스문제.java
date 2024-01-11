package org.example.hcu55.baekjoon.impl;

import java.util.LinkedList;
import java.util.Scanner;

// 요세푸스 문제, 실버 IV
public class 요세푸스문제 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();

        int N = sc.nextInt();
        int K = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append('<');

        int index = 0;    // 리스트에서 삭제 인덱스 변수

        while (list.size() > 1) {
            index = (index + (K - 1)) % list.size();        // 인덱스 번호 추출

            int delete = list.remove(index);    // 삭제할 변수 추출
            sb.append(delete).append(", ");
        }

        sb.append(list.remove()).append('>');
        System.out.println(sb);
    }
}
