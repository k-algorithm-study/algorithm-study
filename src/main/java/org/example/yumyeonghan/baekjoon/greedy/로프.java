package org.example.yumyeonghan.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

// https://www.acmicpc.net/problem/2217
public class 로프 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] rope = new Integer[n];
    for (int i = 0; i < n; i++) {
      rope[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(rope, Collections.reverseOrder());
    long max = -(int) 1e9;

    // ex) 30, 25, 20, 10
    /**
     * 중량   최대
     * 30 -> 30 * 1
     * 25 -> 25 * 2
     * 20 -> 20 * 3
     * 10 -> 10 * 4
     * 이 중, 최대 중량은 60
     */
    for (int i = 0; i < n; i++) {
      max = Math.max(max, rope[i] * (i + 1));
    }
    System.out.println(max);
  }

}
