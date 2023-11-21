package org.example.yumyeonghan.baekjoon.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// https://www.acmicpc.net/problem/10773
public class 제로 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int k = Integer.parseInt(br.readLine());
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < k; i++) {
      int tmp = Integer.parseInt(br.readLine());
      if (tmp == 0) {
        stack.pop();
      } else {
        stack.push(tmp);
      }
    }

    int sum = 0;
    for (int num : stack) {
      sum += num;
    }
    System.out.println(sum);
  }

}
