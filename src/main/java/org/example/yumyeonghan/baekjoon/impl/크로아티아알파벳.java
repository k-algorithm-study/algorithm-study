package org.example.yumyeonghan.baekjoon.impl;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2941
public class 크로아티아알파벳 {

  public static void main(String[] args) {
    String[] alpha = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    for (int i = 0; i < alpha.length; i++) {
      if (input.contains(alpha[i])) {
        input = input.replace(alpha[i], "#");
      }
    }
    System.out.println(input.length());
  }

}
