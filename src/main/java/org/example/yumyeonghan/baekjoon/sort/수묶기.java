package org.example.yumyeonghan.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://www.acmicpc.net/problem/1744
public class 수묶기 {

  /**
   * 1. 양수는 큰거부터 2개씩 짝지어서 곱하고, 나머지는 더한다. (내림차순)
   * 2. 1은 곱하면 그대로 이므로 그냥 더한다. (오름차순)
   * 3. 음수는 작은 수 2개씩 짝지어서 곱하고, 나머지는 0과 곱하거나 0이 없으면 그대로 더한다.
   */

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> plus = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> minus = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(br.readLine());
      if (num <= 0) {
        minus.add(num);
      } else {
        plus.add(num);
      }
    }

    int sum = 0;
    while (!plus.isEmpty()) {
      int currentNumber = plus.poll();
      if (plus.isEmpty()) {
        sum += currentNumber;
        break;
      }
      if (currentNumber == 1) {
        sum += 1;
      } else if (plus.peek() == 1) {
        sum += currentNumber + plus.poll();
      } else {
        sum += currentNumber * plus.poll();
      }
    }

    while (!minus.isEmpty()) {
      Integer currentNumber = minus.poll();
      if (minus.isEmpty()) {
        sum += currentNumber;
        break;
      }
      if (minus.peek() == 0) {
        minus.poll();
      } else {
        sum += currentNumber * minus.poll();
      }
    }
    System.out.println(sum);
  }

}
