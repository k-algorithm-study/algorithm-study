package org.example.yumyeonghan.baekjoon.sort;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/2108
public class 통계학 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int cnt = scanner.nextInt();
    int[] nums = new int[cnt];
    double sum = 0;

    for (int i = 0; i < cnt; i++) {
      nums[i] = scanner.nextInt();
      sum += nums[i];
    }
    Arrays.sort(nums);

    int count = 0;
    int frequency = -(int) 1e9;
    int mode = nums[0];
    boolean check = false;

    for (int i = 0; i < cnt - 1; i++) {
      if (nums[i] == nums[i + 1]) {
        count++;
      } else {
        count = 0;
      }
      if (frequency < count) {
        frequency = count;
        mode = nums[i];
        check = true;
      } else if (frequency == count && check == true) { // 최빈값 중 두 번째로 작은 값 update
        mode = nums[i];
        check = false;
      }
    }
    System.out.println(Math.round(sum / cnt)); // 1. 산술평균
    System.out.println(nums[(cnt - 1) / 2]); // 2. 중앙값
    System.out.println(mode); // 3. 최빈값
    System.out.println(nums[cnt - 1] - nums[0]); // 4. 최대값 - 최소값
  }

}
