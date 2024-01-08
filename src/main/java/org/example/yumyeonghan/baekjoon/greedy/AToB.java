package org.example.yumyeonghan.baekjoon.greedy;

import java.util.Scanner;

// https://www.acmicpc.net/problem/16953
public class AToB {

  private static boolean flag;
  private static int answer;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    long a = scanner.nextInt();
    long b = scanner.nextInt();
    dfs(a, b, 1);
    if (flag) {
      System.out.println(answer);
    } else {
      System.out.println(-1);
    }
  }

  private static void dfs(long a, long b, int count) {
    if (a == b) {
      answer = count;
      flag = true;
      return;
    }
    if (a < b) {
      dfs(a * 2, b, count + 1);
      dfs(a * 10 + 1, b, count + 1);
    }
  }

}
