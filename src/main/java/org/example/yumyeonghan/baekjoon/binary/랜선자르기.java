package org.example.yumyeonghan.baekjoon.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1654
public class 랜선자르기 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int k = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());
    long[] arr = new long[k];
    long start = 1;
    long end = 0;
    for (int i = 0; i < k; i++) {
      arr[i] = Integer.parseInt(br.readLine());
      if (end < arr[i]) {
        end = arr[i];
      }
    }
    long result = end;

    while (!(end < start)) {
      long mid = (start + end) / 2;
      long sum = 0;
      for (int i = 0; i < k; i++) {
        sum += (arr[i] / mid);
      }
      if (sum >= n) {
        start = mid + 1;
        result = mid;
      } else {
        end = mid - 1;
      }
    }
    System.out.println(result);
  }

}
