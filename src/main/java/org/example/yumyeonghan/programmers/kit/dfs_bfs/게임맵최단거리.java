package org.example.yumyeonghan.programmers.kit.dfs_bfs;

import java.util.ArrayDeque;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/1844
public class 게임맵최단거리 {

  int[] dx = {0, 0, -1, 1};
  int[] dy = {1, -1, 0, 0};
  int[][] visited;

  public int solution(int[][] maps) {
    visited = new int[maps.length][maps[0].length];
    bfs(maps);
    int answer = visited[maps.length - 1][maps[0].length - 1];
    if (answer == 0) {
      return -1;
    }
    return answer;
  }

  public void bfs(int[][] maps) {
    int x = 0;
    int y = 0;
    visited[x][y] = 1;
    Queue<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{x, y});

    while (!queue.isEmpty()) {
      int[] pos = queue.poll();
      int currentX = pos[0];
      int currentY = pos[1];
      for (int i = 0; i < 4; i++) {
        int nx = currentX + dx[i];
        int ny = currentY + dy[i];

        if (nx < 0 || nx > maps.length - 1 || ny < 0 || ny > maps[0].length - 1) {
          continue;
        }

        if (visited[nx][ny] == 0 && maps[nx][ny] == 1) {
          visited[nx][ny] = visited[currentX][currentY] + 1;
          queue.add(new int[]{nx, ny});
        }
      }
    }
  }

}
