package org.example.kw99j10.baekjoon.greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 카드 정렬하기 - Gold IV
 */
public class Greedy08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PriorityQueue<Integer> queue = new PriorityQueue<>(); //주어진 카드 묶음을 담을 큐
        for (int i = 0; i < n; i++) {
            queue.add(sc.nextInt());
        }

        long sum = 0L; //최소 비교 횟수

        //큐의 사이즈가 1이면 묶음을 종료
        while (queue.size() != 1) {

            int a = queue.remove();
            int b = queue.remove();

            sum += a + b;
            queue.add(a + b);
        }
        System.out.println(sum);
    }
}
