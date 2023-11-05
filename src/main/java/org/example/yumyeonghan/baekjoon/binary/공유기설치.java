package org.example.yumyeonghan.baekjoon.binary;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/2110
public class 공유기설치 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(); //집 개수
    int c = sc.nextInt(); // 공유기 개수
    int[] house = new int[n];
    int answer = 0;
    for (int i = 0; i < n; i++) {
      house[i] = sc.nextInt();
    }
    Arrays.sort(house);
    int start = 1; // 사이 거리 1
    int end = house[n - 1] - house[0]; // 사이 거리 : 마지막 집 - 첫 집 차이
    while (!(start > end)) {
      int mid = (start + end) / 2; // 최대로 구할 사이 거리
      int fixHouse = house[0]; // 1번 집은 무조건 넣어야 사이 거리의 최대 값이 나옴
      int count = 1; // 1번집 설치
      for (int i = 0; i < n; i++) {
        int dis = house[i] - fixHouse;
        if (dis >= mid) {
          count += 1;
          fixHouse = house[i];
        }
      }
      // 사이 거리를 mid 로 설정할 때 공유기가 더 설치 되면, 간격을 넓혀야 하고, 그렇지 않으면 좁혀야 함
      if (count >= c) {
        start = mid + 1;
        answer = mid;
      } else {
        end = mid - 1;
      }
    }
    System.out.println(answer);
  }

}
