package org.example.yumyeonghan.baekjoon.impl;

import java.util.Scanner;

// https://www.acmicpc.net/problem/7568
public class 덩치 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] weight = new int[n];
    int[] height = new int[n];
    int[] rank = new int[n];
    for (int i = 0; i < n; i++) {
      weight[i] = scanner.nextInt();
      height[i] = scanner.nextInt();
    }
    for (int i = 0; i < n; i++) {
      int rankScore = 0;
      for (int j = 0; j < n; j++) {
        if (i == j) {
          continue;
        }
        if (weight[i] < weight[j] && height[i] < height[j]) {
          rankScore += 1;
        }
      }
      rank[i] = rankScore + 1;
    }
    for (int i = 0; i < n; i++) {
      System.out.print(rank[i] + " ");
    }
  }

}
