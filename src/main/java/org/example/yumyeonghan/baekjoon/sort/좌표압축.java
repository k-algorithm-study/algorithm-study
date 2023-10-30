package org.example.yumyeonghan.baekjoon.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// https://www.acmicpc.net/problem/18870
public class 좌표압축 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] origin = new int[n];
    int[] sorted = new int[n];
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    for (int i = 0; i < n; i++) {
      origin[i] = scanner.nextInt();
      sorted[i] = origin[i];
    }
    Arrays.sort(sorted);
    int rank = 0;
    for (int v : sorted) {
      if (!map.containsKey(v)) {
        map.put(v, rank);
        rank += 1;
      }
    }

    StringBuilder stringBuilder = new StringBuilder();
    for (int key : origin) {
      int ranking = map.get(key);
      stringBuilder.append(ranking).append(' ');
    }
    System.out.println(stringBuilder);
  }

}
