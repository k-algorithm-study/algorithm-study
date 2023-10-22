package org.example.yumyeonghan.programmers.level1;

import java.util.ArrayList;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/161990
public class 바탕화면정리 {

  public int[] solution(String[] wallpaper) {
    //wallpaper.lenth: x좌표,wallpaper[0].lenth(): y좌표
    int x = wallpaper.length;
    int y = wallpaper[0].length();

    //1. 바탕화면의 상태를 나타낸 wallpaper에서 각 파일들의 위치 구한다.
    List<Integer[]> files = new ArrayList<>();
    for (int i = 0; i < x; i++) {
      for (int j = 0; j < y; j++) {
        if (wallpaper[i].charAt(j) == '#') {
          files.add(new Integer[]{i, j});
        }
      }
    }

    //2. 해당 파일들을 한번에 삭제하기 위해 |rdx - lux| + |rdy - luy| 이것이 최소가 되는 좌표를 1번에서 구한 위치를 갖고 구한다.
    //2-1 파일들의 위치를 갖고 가장 작은 직사각형을 만들고 끝의 두 지점의 좌표를 구하면 된다.
    //이때 드래그 시작점 (lux, luy)와 끝점 (rdx, rdy)는 lux < rdx, luy < rdy를 만족해야 합니다.
    //왼쪽위는 x, y가 가장 작은거 오른쪽 아래는 x, y가 가장 큰것
    int minX = Integer.MAX_VALUE;
    int minY = Integer.MAX_VALUE;
    int maxX = Integer.MIN_VALUE;
    int maxY = Integer.MIN_VALUE;

    for (Integer[] file : files) {
      if (file[0] < minX) {
        minX = file[0];
      }
      if (file[1] < minY) {
        minY = file[1];
      }
      if (file[0] > maxX) {
        maxX = file[0];
      }
      if (file[1] > maxY) {
        maxY = file[1];
      }
    }
    return new int[]{minX, minY, maxX + 1, maxY + 1};
  }

}
