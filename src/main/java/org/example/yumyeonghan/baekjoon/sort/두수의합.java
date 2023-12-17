package org.example.yumyeonghan.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/3273
public class 두수의합 {

  public static void main(String[] args) throws IOException {
    long answer = 0;
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bufferedReader.readLine());
    int[] arr = new int[n];
    StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int x = Integer.parseInt(bufferedReader.readLine());
    Arrays.sort(arr);

    int start = 0;
    int end = n - 1;
    while (start < end) {
      long sum = arr[start] + arr[end];
      if (sum == x) {
        answer += 1;
      }
      if (sum <= x) {
        start += 1;
      } else {
        end -= 1;
      }
    }
    System.out.println(answer);
  }

}
