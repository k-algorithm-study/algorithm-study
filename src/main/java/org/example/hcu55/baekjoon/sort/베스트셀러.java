package org.example.hcu55.baekjoon.sort;

import java.util.*;

// 베스트셀러, 실버 IV
public class 베스트셀러 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();     // 책 이름, 개수

        for (int i = 0; i < N; i++) {   // 맵에 넣기
            String book = sc.next();
            map.put(book, map.getOrDefault(book, 0) + 1);
        }

        int max = 0;
        for (String a : map.keySet()) {         // 가장 많은 책 개수 찾기
            max = Math.max(max, map.get(a));
        }

        ArrayList<String> arr = new ArrayList<>(map.keySet());
        Collections.sort(arr);          // 책 이름으로 정렬

        for (String a : arr) {
            if (map.get(a) == max) {        // 책 개수중 최대 값 첫번째만 뽑기
                System.out.println(a);
                break;
            }
        }
    }
}
