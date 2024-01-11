package org.example.yumyeonghan.programmers.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/86491
public class 최소직사각형 {

  public int solution(int[][] sizes) {
    for (int i = 0; i < sizes.length; i++) {
      int tmp;
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
