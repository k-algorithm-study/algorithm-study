package org.example.yumyeonghan.baekjoon.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1253
public class 좋다 {

  public static void main(String[] args) throws IOException {
    // input value & init arr
    int answer = 0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);

    // search all number
    for (int targetIndex = 0; targetIndex < n; targetIndex++) {
      int start = 0;
      int end = n - 1;

      // search answer (two point)
      while (true) {

        // avoid self
        if (targetIndex == start) {
          start++;
        } else if (end == targetIndex) {
          end--;
        }

        // no answer
        if (start >= end || targetIndex == start || end == targetIndex) {
          break;
        }

        if (arr[start] + arr[end] > arr[targetIndex]) {
          end--;
        } else if (arr[start] + arr[end] < arr[targetIndex]) {
          start++;
        } else {
          answer++;
          break;
        }
      }
    }
    System.out.println(answer);
  }

}
