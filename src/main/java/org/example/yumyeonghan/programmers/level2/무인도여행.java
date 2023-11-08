package org.example.yumyeonghan.programmers.level2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/154540
public class 무인도여행 {

  private int[] dx = {-1, 1, 0, 0};
  private int[] dy = {0, 0, -1, 1};
  private char[][] graph;
  private boolean[][] isVisited;

  public int[] solution(String[] maps) {
    List<Integer> list = new ArrayList<>();
    isVisited = new boolean[maps.length][maps[0].length()];
    graph = new char[maps.length][maps[0].length()];
    for (int i = 0; i < maps.length; i++) {
      for (int j = 0; j < maps[0].length(); j++) {
        graph[i][j] = maps[i].charAt(j);
      }
    }
    for (int i = 0; i < graph.length; i++) {
      for (int j = 0; j < graph[0].length; j++) {
        if (graph[i][j] != 'X' && isVisited[i][j] == false) {
          list.add(bfs(i, j));
        }
      }
    }
    Collections.sort(list);
    return list.size() == 0 ? new int[]{-1} : list.stream().mapToInt(i -> i).toArray();
  }

  private int bfs(int row, int col) {
    isVisited[row][col] = true;
    int sum = 0;
    Queue<int[]> queue = new ArrayDeque<>();
    queue.offer(new int[]{row, col});
    while (!queue.isEmpty()) {
      int[] poll = queue.poll();
      int x = poll[0];
      int y = poll[1];
      sum += graph[x][y] - '0';
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx < 0 || ny < 0 || nx >= graph.length || ny >= graph[0].length) {
          continue;
        }
        if (!isVisited[nx][ny] && graph[nx][ny] != 'X') {
          isVisited[nx][ny] = true;
          queue.offer(new int[]{nx, ny});
        }
      }
    }
    return sum;
  }

}
