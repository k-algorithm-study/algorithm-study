package org.example.hcu55.baekjoon.impl;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

// 덱, 실버 IV
public class 덱 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String command = sc.next();

            if (command.equals("push_front")) {
                int num = sc.nextInt();
                deque.addFirst(num);
            }
            if (command.equals("push_back")) {
                int num = sc.nextInt();
                deque.addLast(num);
            }
            if (command.equals("pop_front")) {
                sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append('\n');
            }
            if (command.equals("pop_back")) {
                sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append('\n');
            }
            if (command.equals("size")) {
                sb.append(deque.size()).append('\n');
            }
            if (command.equals("empty")) {
                sb.append(deque.isEmpty() ? 1 : 0).append('\n');
            }
            if (command.equals("front")) {
                sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append('\n');
            }
            if (command.equals("back")) {
                sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append('\n');
            }
        }
        System.out.print(sb);
    }
}
