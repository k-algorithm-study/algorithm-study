package org.example.hcu55.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

// 리코쳇 로봇, Programmers(Level 2)
public class 리코쳇로봇 {          // bfs사용
    int[] dx = {-1, 0, 1, 0};   //상 우 하 좌
    int[] dy = {0, 1, 0, -1};
    boolean[][] visited;

    public int solution(String[] board) {
        int answer = 0;
        int sr = 0, sc = 0, er = 0, ec = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == 'R') {
                    sr = i;
                    sc = j;
                } else if (board[i].charAt(j) == 'G') {
                    er = i;
                    ec = j;
                }
            }
        }
        visited = new boolean[board.length][board[0].length()];

        answer = bfs(sr, sc, er, ec, board);

        return answer;
    }

    public int bfs(int sr, int sc, int er, int ec, String[] board) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{sr, sc, 0}); //r, c, cnt
        visited[sr][sc] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cnt = poll[2];

            if (poll[0] == er && poll[1] == ec) {
                return cnt;
            }
            for (int i = 0; i < 4; i++) {
                int d = i;
                int r = poll[0];
                int c = poll[1];
                while (true) {
                    int nr = r + dx[d];
                    int nc = c + dy[d];
                    if (nr >= board.length || nr < 0 || nc < 0 || nc >= board[0].length() || board[nr].charAt(nc) == 'D')
                        break;
                    r = nr;
                    c = nc;
                }

                if (r == poll[0] && c == poll[1]) continue;
                if (visited[r][c]) continue;
                else {
                    queue.add(new int[]{r, c, cnt + 1});
                    visited[r][c] = true;
                }
            }
        }
        return -1;
    }
}