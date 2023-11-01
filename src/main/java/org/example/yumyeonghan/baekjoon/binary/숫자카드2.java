package org.example.yumyeonghan.baekjoon.binary;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/10816
public class 숫자카드2 {

  static int[] num;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    StringBuilder stringBuilder = new StringBuilder();
    num = new int[n];
    for (int i = 0; i < n; i++) {
      num[i] = scanner.nextInt();
    }
    Arrays.sort(num);
    int m = scanner.nextInt();
    for (int i = 0; i < m; i++) {
      int comparingNumber = scanner.nextInt();
      stringBuilder.append(upperBound(comparingNumber) - lowerBound(comparingNumber) + " ");
    }
    System.out.println(stringBuilder);
  }

  private static int lowerBound(int comparingNumber) {
    int start = 0;
    int end = num.length;
    while (start < end) {
      int mid = (start + end) / 2;
      if (comparingNumber <= num[mid]) {
        end = mid;
      } else {
        start = mid + 1;
      }
    }
    return end;
  }

  private static int upperBound(int comparingNumber) {
    int start = 0;
    int end = num.length;
    while (start < end) {
      int mid = (start + end) / 2;
      if (comparingNumber < num[mid]) {
        end = mid;
      } else {
        start = mid + 1;
      }
    }
    return end;
  }

}
