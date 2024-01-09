package org.example.yumyeonghan.baekjoon.impl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1158
public class 요세푸스문제 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int k = scanner.nextInt();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("<");
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
      queue.add(i);
    }
    int count = 0;
    while (queue.size() > 1) {
      count++;
      Integer number = queue.poll();
      if (count % k == 0) {
        stringBuilder.append(number).append(", ");
      } else {
        queue.add(number);
      }
    }
    stringBuilder.append(queue.poll()).append(">");
    System.out.println(stringBuilder);
  }

}
