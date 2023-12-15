package org.example.kw99j10.baekjoon.implementation;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * 덱 - Silver IV
 */
public class Implementation08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String s = sc.next();

            if (s.contains("push")) {
                int x = sc.nextInt();

                if (s.contains("back")) {
                    arrayDeque.addLast(x);
                }
                else{
                    arrayDeque.addFirst(x);
                }
            }
            if (s.contains("pop")) {
                if (s.contains("front")) {
                    sb.append(arrayDeque.isEmpty() ? -1 : arrayDeque.removeFirst()).append("\n");
                }
                else{
                    sb.append(arrayDeque.isEmpty() ? -1 : arrayDeque.removeLast()).append("\n");
                }
            }
            if (s.equals("size")) {
                sb.append(arrayDeque.size()).append("\n");
            }
            if (s.equals("empty")) {
                sb.append(arrayDeque.isEmpty() ? 1 : 0).append("\n");
            }
            if (s.equals("front")) {
                sb.append(arrayDeque.isEmpty() ? -1 : arrayDeque.getFirst()).append("\n");
            }
            if (s.equals("back")) {
                sb.append(arrayDeque.isEmpty() ? -1 : arrayDeque.getLast()).append("\n");
            }
        }
        System.out.print(sb);
    }
}
