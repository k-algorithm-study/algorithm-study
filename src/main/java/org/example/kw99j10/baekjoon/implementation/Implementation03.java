package org.example.kw99j10.baekjoon.implementation;

import java.util.Scanner;
import java.util.Stack;

/**
 * 스택 - Silver IV
 */
public class Implementation03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //명령의 수

        var s = new Stack<Integer>(); //명령에서 주어진 정수를 담을 stack

        StringBuilder sb = new StringBuilder(); //명령을 출력할 객체

        for (int i = 0; i < n; i++) {
            String order = sc.next(); //명령
            if (order.equals("push")) {
                s.push(sc.nextInt()); //stack에 push
            }
            if (order.equals("pop")) {
                if (s.isEmpty()) {
                    sb.append(-1).append("\n");
                }
                else{
                    sb.append(s.pop()).append("\n");
                }
            }
            if (order.equals("size")) {
                sb.append(s.size()).append("\n");
            }
            if (order.equals("empty")) {
                if (s.isEmpty()) {
                    sb.append(1).append("\n");
                }
                else{
                    sb.append(0).append("\n");
                }
            }
            if (order.equals("top")) {
                if (s.isEmpty()) {
                    sb.append(-1).append("\n");
                }
                else{
                    sb.append(s.peek()).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}
