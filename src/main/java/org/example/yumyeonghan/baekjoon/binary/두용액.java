package org.example.yumyeonghan.baekjoon.binary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2470
public class 두용액 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.valueOf(br.readLine());
    int[] list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    Arrays.sort(list);
    int[] result = calculateArr(list, N);

    bw.write(result[0] + " " + result[1] + "\n");
    bw.flush();
    bw.close();
  }

  private static int[] calculateArr(int[] list, int n) {
    // 리스트의 인덱스 처음과 끝
    int start = 0;
    int end = n - 1;
    // 차이가 가장 클때의 값
    int difference = 2000000000;
    int[] result = new int[2];
    while (start < end) {
      int sum = list[start] + list[end];
      // 0에 더 가까운 수 찾기
      if (Math.abs(sum) < difference) {
        result[0] = list[start];
        result[1] = list[end];
        difference = Math.abs(sum);
      }
      if (sum > 0) {
        end--;
      } else {
        start++;
      }
    }
    return result;
  }

}
