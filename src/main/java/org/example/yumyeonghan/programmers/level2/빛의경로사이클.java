package org.example.yumyeonghan.programmers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/86052
public class 빛의경로사이클 {

  private boolean[][][] isVisited; //[행][열][방향]
  private int r, c; //행, 열
  private int[] dr = {-1, 0, 1, 0};
  private int[] dc = {0, -1, 0, 1};

  public int[] solution(String[] grid) {
    // init
    List<Integer> answer = new ArrayList<>();
    r = grid.length;
    c = grid[0].length();
    isVisited = new boolean[r][c][4];

    // cycle counting (full search)
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        for (int k = 0; k < 4; k++) {
          if (!isVisited[i][j][k]) {
            answer.add(cycle(grid, i, j, k));
          }
        }
      }
    }

    // output answer
    Collections.sort(answer);
    return answer.stream().mapToInt(e -> e).toArray();
  }

  private Integer cycle(String[] grid, int searchR, int searchC, int direction) {
    int count = 0;
    // 사이클이 완성되어 처음 위치로 오는 경우까지 반복
    while (!isVisited[searchR][searchC][direction]) {
      count++;
      isVisited[searchR][searchC][direction] = true;

      // L, R에 따른 방향 수정
      if (grid[searchR].charAt(searchC) == 'L') {
        direction = (direction + 1) % 4;
      } else if (grid[searchR].charAt(searchC) == 'R') {
        direction = (direction + 3) % 4;
      }
      // 격자 끝을 지나 다시 반대쪽으로 넘어가는 경우
      searchR = (searchR + dr[direction] + r) % r;
      searchC = (searchC + dc[direction] + c) % c;
    }
    return count;
  }

  public static void main(String[] args) {
    빛의경로사이클 빛의경로사이클 = new 빛의경로사이클();
    빛의경로사이클.solution(new String[]{"SL", "LR"});
  }

}
