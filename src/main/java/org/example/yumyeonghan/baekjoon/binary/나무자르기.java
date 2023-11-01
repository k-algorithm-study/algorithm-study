package org.example.yumyeonghan.baekjoon.binary;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2805
public class 나무자르기 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    long m = scanner.nextInt();
    int min = 0;
    int max = 0;
    int[] trees = new int[n];
    for (int i = 0; i < n; i++) {
      trees[i] = scanner.nextInt();
      if (trees[i] > max) {
        max = trees[i];
      }
    }

    // binary search (upperBound) => 나무 높이의 최대값을 구해야 하므로
    while (min < max) {
      int mid = (min + max) / 2;
      long sum = 0;
      for (int tree : trees) {
        if (tree > mid) {
          sum += (tree - mid);
        }
      }
      if (sum < m) {
        max = mid;
      } else {
        min = mid + 1;
      }
    }
    System.out.println(max);
  }

}
