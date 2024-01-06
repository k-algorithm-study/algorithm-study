package org.example.kw99j10.baekjoon.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *  베스트셀러 - Silver IV
 */
public class Sort09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        var book = new HashMap<String, Integer>();

        for (int i = 0; i < n; i++) {
            String title = sc.next();
            book.put(title, book.getOrDefault(title, 0) + 1);
        }

        var list = new ArrayList<>(book.entrySet());

        //가장 많이 팔린 책의 수 -> 책 제목 순 정렬
        list.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue() - o1.getValue();
        });
        System.out.println(list.get(0).getKey());
    }
}
