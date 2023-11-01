package org.example.yumyeonghan.baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1931
public class 회의실배정 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[][] time = new int[n][2];
    for (int i = 0; i < n; i++) {
      time[i][0] = in.nextInt();  // 시작시간
      time[i][1] = in.nextInt();  // 종료시간
    }
    Arrays.sort(time, (o1, o2) -> {
      // 종료 시간이 같을 경우 시작 시간 오름차순
      if (o1[1] == o2[1]) {
        return o1[0] - o2[0];
      }
      return o1[1] - o2[1];
    });
    int count = 1;
    int tmp = time[0][1];
    for (int i = 1; i < time.length; i++) {
      if (tmp <= time[i][0]) {
        tmp = time[i][1];
        count += 1;
      }
    }
    System.out.println(count);
  }

}
