package org.example.yumyeonghan.baekjoon.binary;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1072
public class 게임 {

  public static void main(String[] args) {
    int answer = -1;
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
    int y = sc.nextInt();
    int z = getScore(x, y);

    int start = 1;
    int end = (int) 1e9;
    while (start <= end) {
      // 더 해야하는 게임 횟수
      int mid = (start + end) / 2;
      // 앞으로는 이기기만 한다는 조건이 있음
      int score = getScore(x + mid, y + mid);
      // 현재 스코어보다 크면 횟수를 줄이고, 현재 스코어보다 작으면 횟수를 늘려서 mid 의 최솟값을 구함
      if (z < score) {
        answer = mid;
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    System.out.println(answer);
  }

  public static int getScore(int x, int y) {
    return (int) ((long) y * 100 / x);
  }

}
