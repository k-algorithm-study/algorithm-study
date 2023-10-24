package org.example.yumyeonghan.programmers.level2;

import java.util.ArrayDeque;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/169199
public class 리코쳇로봇 {

  private int[] dx = {0, 0, -1, 1};
  private int[] dy = {1, -1, 0, 0};
  private boolean[][] visited;

  public int solution(String[] board) {
    int answer = -1;
    visited = new boolean[board.length][board[0].length()];
    Queue<int[]> queue = new ArrayDeque<>();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length(); j++) {
        if (board[i].charAt(j) == 'R') {
          queue.offer(new int[]{i, j, 0}); // {x, y, depth}
          visited[i][j] = true;
        }
      }
    }
    while (!queue.isEmpty()) {
      int[] e = queue.poll();
      int x = e[0];
      int y = e[1];
      int depth = e[2];

      if (board[x].charAt(y) == 'G') {
        answer = depth;
        break;
      }

      for (int i = 0; i < 4; i++) {
        int nx = x;
        int ny = y;

        while (nx >= 0 && ny >= 0 && nx < board.length && ny < board[0].length()
            && board[nx].charAt(ny) != 'D') {
          nx += dx[i];
          ny += dy[i];
        }

        // 장애물에 부딫히거나 범위 벗어날때까지 반복후, 그전으로 롤백
        nx -= dx[i];
        ny -= dy[i];

        // 롤백 된 위치가 자기 위치거나, 방문한 적이 있으면 생략 (무한 루프 방지)
        if (visited[nx][ny] || (x == nx && y == ny)) {
          continue;
        }
        visited[nx][ny] = true;
        queue.offer(new int[]{nx, ny, depth + 1});
      }
    }
    return answer;
  }

}
