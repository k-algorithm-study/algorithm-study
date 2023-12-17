package org.example.yumyeonghan.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// https://www.acmicpc.net/problem/1715
public class 카드정렬하기 {

  public static void main(String[] args) throws IOException {
    long answer = 0;
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bufferedReader.readLine());
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      queue.add(Integer.valueOf(bufferedReader.readLine()));
    }
    while (queue.size() > 1) {
      Integer firstNum = queue.poll();
      Integer secondNum = queue.poll();
      answer += firstNum + secondNum;
      queue.add(firstNum + secondNum);
    }
    System.out.println(answer);

  }

}
