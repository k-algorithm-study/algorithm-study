package org.example.hcu55.baekjoon.sort;

import java.util.*;

// N번째 큰 수, 실버 II
public class N번째큰수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder()); // 숫자가 큰 수 부터 나오도록

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                queue.add(sc.nextInt());
            }
        }

        for (int i = 0; i < N - 1; i++) {
            queue.poll();
        }

        System.out.println(queue.poll());
    }
}
