package org.example.kw99j10.programmers.lv2;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 빛의 경로 사이클, programmers:Level 2
 */

public class 빛의경로사이클 {
    static int r; //격자의 행
    static int c; //격자의 열
    static boolean[][][] visit; //방문을 확인할 배열
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1}; //상,하,좌,우
    public int[] solution(String[] grid) {

        r = grid.length;
        c = grid[0].length();

        var list = new ArrayList<Integer>();
        visit = new boolean[r][c][4]; //행,열,방향

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int d = 0; d < 4; d++) {
                    if (!visit[i][j][d]) {
                        list.add(light(grid, i, j, d));
                    }
                }
            }
        }

        Collections.sort(list); //오름차순 정렬
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    //빛의 이동 방향에 따른 거리
    static int light(String[] grid, int i, int j, int d) {
        int distance = 0;
        while (!visit[i][j][d]) {

            distance += 1;
            visit[i][j][d] = true;

            if (grid[i].charAt(j) == 'L') {
                d = d == 0 ? 3 : d - 1; //좌회전
            } else if (grid[i].charAt(j) == 'R') {
                d = d == 3 ? 0 : d + 1; //우회전
            }

            i = (i + dx[d] + r) % r;
            j = (j + dy[d] + c) % c;
        }
        return distance;
    }
}
