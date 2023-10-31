package org.example.yumyeonghan.programmers.level2;

import java.util.ArrayDeque;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/159993
public class 미로탈출 {

  private Character[][] graph;
  private int[] dx = {0, 0, -1, 1};
  private int[] dy = {1, -1, 0, 0};

  public int solution(String[] maps) {
    graph = new Character[maps.length][maps[0].length()];
    int[] lever = new int[2];
    int[] start = new int[2];
    for (int i = 0; i < maps.length; i++) {
      for (int j = 0; j < maps[0].length(); j++) {
        graph[i][j] = maps[i].charAt(j);
        if (graph[i][j].equals('S')) {
          start[0] = i;
          start[1] = j;
        }
        if (graph[i][j].equals('L')) {
          lever[0] = i;
          lever[1] = j;
        }
      }
    }
    int toLever = bfs(start, 'L');
    int toExit = bfs(lever, 'E');

    if (toLever == -1 || toExit == -1) {
      return -1;
    }
    return toLever + toExit;
  }

  private int bfs(int[] startPoint, Character targetPoint) {
    Queue<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{startPoint[0], startPoint[1], 0});
    boolean[][] visited = new boolean[graph.length][graph[0].length];
    while (!queue.isEmpty()) {
      int[] inf = queue.poll();
      int x = inf[0];
      int y = inf[1];
      int count = inf[2];
      visited[x][y] = true;
      if (graph[x][y].equals(targetPoint)) {
        return count;
      }
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx >= 0 && nx < graph.length && ny >= 0 && ny < graph[0].length && !visited[nx][ny]) {
          if (!graph[nx][ny].equals('X')) {
            visited[nx][ny] = true;
            queue.add(new int[]{nx, ny, count + 1});
          }
        }
      }
    }
    return -1;
  }

}
