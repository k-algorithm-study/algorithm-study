package org.example.yumyeonghan.programmers.kit.brute_force;

// https://school.programmers.co.kr/learn/courses/30/lessons/86491
public class 최소직사각형 {

  public static void main(String[] args) {
    System.out.println(new 최소직사각형().solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}}));
  }

  public int solution(int[][] sizes) {
    for (int i = 0; i < sizes.length; i++) {
      int tmp = 0;
      if (sizes[i][0] > sizes[i][1]) {
        tmp = sizes[i][1];
        sizes[i][1] = sizes[i][0];
        sizes[i][0] = tmp;
      }
    }

    int xMax = -1;
    int yMax = -1;
    for (int i = 0; i < sizes.length; i++) {
      if (sizes[i][0] > xMax) {
        xMax = sizes[i][0];
      }
      if (sizes[i][1] > yMax) {
        yMax = sizes[i][1];
      }
    }
    return xMax * yMax;
  }

}
