package org.example.hcu55.baekjoon.sort;

import java.util.*;

// 중복 빼고 정렬하기, 실버 V
public class 중복빼고정렬하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(sc.nextInt());
        }
        ArrayList<Integer> arr = new ArrayList<>(set);
        Collections.sort(arr);

        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
    }
}
