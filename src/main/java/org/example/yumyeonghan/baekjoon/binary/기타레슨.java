package org.example.yumyeonghan.baekjoon.binary;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2343
public class 기타레슨 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] lecture = new int[n];
    int start = 0;
    int end = 0;
    // init start (가장 긴 강의) & end (모든 강의의 총합)
    for (int i = 0; i < n; i++) {
      lecture[i] = sc.nextInt();
      if (start < lecture[i]) {
        start = lecture[i];
      }
      end = end + lecture[i];
    }

    // start binary search
    while (start <= end) {
      int mid = (start + end) / 2; // 모든 강의를 저장 가능한 블루레이 하나의 크기
      int sum = 0;
      int count = 1;

      // 몇개의 블루레이가 필요한지 체크
      for (int i = 0; i < n; i++) {
        if (sum + lecture[i] > mid) {
          count += 1;
          sum = 0;
        }
        sum += lecture[i];
      }

      // 블루레이 개수를 조건 m(블루레이 개수)과 비교
      if (count > m) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    System.out.println(start);
  }

}
