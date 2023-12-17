package org.example.yumyeonghan.baekjoon.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/10866
public class 덱 {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bufferedReader.readLine());
    StringBuilder stringBuilder = new StringBuilder();
    Deque<Integer> deque = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      String str = stringTokenizer.nextToken();
      switch (str) {
        case "push_front":
          deque.addFirst(Integer.parseInt(stringTokenizer.nextToken()));
          break;
        case "push_back":
          deque.addLast(Integer.parseInt(stringTokenizer.nextToken()));
          break;
        case "pop_front":
          if (deque.isEmpty()) {
            stringBuilder.append(-1).append("\n");
          } else {
            stringBuilder.append(deque.pollFirst()).append("\n");
          }
          break;
        case "pop_back":
          if (deque.isEmpty()) {
            stringBuilder.append(-1).append("\n");
          } else {
            stringBuilder.append(deque.pollLast()).append("\n");
          }
          break;
        case "size":
          stringBuilder.append(deque.size()).append("\n");
          break;
        case "empty":
          if (deque.isEmpty()) {
            stringBuilder.append(1).append("\n");
          } else {
            stringBuilder.append(0).append("\n");
          }
          break;
        case "front":
          if (deque.isEmpty()) {
            stringBuilder.append(-1).append("\n");
          } else {
            stringBuilder.append(deque.peekFirst()).append("\n");
          }
          break;
        case "back":
          if (deque.isEmpty()) {
            stringBuilder.append(-1).append("\n");
          } else {
            stringBuilder.append(deque.peekLast()).append("\n");
          }
          break;
      }
    }
    System.out.println(stringBuilder);
  }

}
