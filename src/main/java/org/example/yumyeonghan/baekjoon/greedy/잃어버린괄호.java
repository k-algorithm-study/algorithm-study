package org.example.yumyeonghan.baekjoon.greedy;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1541
public class 잃어버린괄호 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String[] str = scanner.nextLine().split("-");
    int sum = (int) 1e9;
    for (String s : str) {
      int tmp = 0;
      String[] nums = s.split("\\+");
      for (int i = 0; i < nums.length; i++) {
        tmp += Integer.valueOf(nums[i]);
      }
      if (sum == (int) 1e9) {
        sum = tmp;
      } else {
        sum -= tmp;
      }
    }
    System.out.println(sum);
  }

}
