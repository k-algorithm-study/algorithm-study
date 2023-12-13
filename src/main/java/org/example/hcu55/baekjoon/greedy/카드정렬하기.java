package org.example.hcu55.baekjoon.greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

// 카드 정렬하기, 골드 IV
public class 카드정렬하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        PriorityQueue<Long> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {   // 카드 묶음 입력 받기
            queue.add(sc.nextLong());
        }

        long sum = 0;

        while (queue.size() > 1) {      // 큐에 카드 묶음 2개 이상일떄만 더 할 수 있음
            long card1 = queue.poll();
            long card2 = queue.poll();

            sum += card1 + card2;
            queue.add(card1 + card2);
        }
        System.out.println(sum);
    }
}
