package org.example.yumyeonghan.baekjoon.impl;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

// https://www.acmicpc.net/problem/10828
public class 스택 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Deque deque = new ArrayDeque();
    StringBuilder stringBuilder = new StringBuilder();
    int n = scanner.nextInt();
    for (int i = 0; i < n; i++) {
      String str = scanner.next();
      if (str.equals("push")) {
        deque.push(scanner.nextInt());
      } else if (str.equals("top")) {
        if (deque.isEmpty()) {
          stringBuilder.append(-1 + "\n");
        } else {
          stringBuilder.append(deque.peek() + "\n");
        }
      } else if (str.equals("size")) {
        stringBuilder.append(deque.size() + "\n");
      } else if (str.equals("empty")) {
        if (deque.isEmpty()) {
          stringBuilder.append(1 + "\n");
        } else {
          stringBuilder.append(0 + "\n");
        }
      } else if (str.equals("pop")) {
        if (deque.isEmpty()) {
          stringBuilder.append(-1 + "\n");
        } else {
          stringBuilder.append(deque.pop() + "\n");
        }
      }
    }
    System.out.println(stringBuilder);
  }

}
