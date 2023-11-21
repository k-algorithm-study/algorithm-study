package org.example.yumyeonghan.baekjoon.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// https://www.acmicpc.net/problem/10610
public class 삼십 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s = scanner.next();
    List<Integer> list = new ArrayList<>();
    int sum = 0;

    for (int i = 0; i < s.length(); i++) {
      sum += s.charAt(i) - '0';
      list.add(s.charAt(i) - '0');
    }
    // 값이 0으로 끝나야 하고, 각 자리의 수 합이 3의 배수가 돼아 한다.
    // 그렇지 않으면 어떻게 정렬이 되든 -1 반환을 하므로,
    Collections.sort(list, Collections.reverseOrder());
    if (list.get(list.size() - 1) == 0 && sum % 3 == 0) {
      for (int i = 0; i < list.size(); i++) {
        System.out.print(list.get(i));
      }
    } else {
      System.out.println(-1);
    }
  }

}
