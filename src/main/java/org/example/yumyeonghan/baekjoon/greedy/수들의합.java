package org.example.yumyeonghan.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1789
public class 수들의합 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long S = Long.parseLong(br.readLine());
    int n = 0;
    int index = 0;
    long sum = 0L;
    while (true) {
      index++;
      sum += index;
      // 순차적으로 더해나갔는데 만약 S를 넘어가면 해당 n 반환 => 언제든지 n개의 숫자로 원하는 숫자를 만들 수 있으므로
      if (sum > S) {
        break;
      }
      n++;
    }
    System.out.println(n);
  }

}
