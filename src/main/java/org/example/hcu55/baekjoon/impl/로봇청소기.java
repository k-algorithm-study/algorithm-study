package org.example.hcu55.baekjoon.impl;

import java.util.*;

// 로봇 청소기, 골드 V
public class 로봇청소기 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};        // (0-북쪽, 1-동쪽, 2-남쪽, 3-서쪽)
    static int N, M;
    static int r, c, d;
    static int[][] area;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();
        area = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                area[i][j] = sc.nextInt();
            }
        }

        int result = 0;

        boolean run = true;     // 종료조건을 만나면 멈추기 위한 run
        while (run) {
            // 1. 청소되지 않은 칸이면 청소하기
            if (area[r][c] == 0) {
                result++;
                area[r][c] = -1;       // 청소했음을 표시하기 위함
            }

            boolean check = false;          // 4방향 청소 유무 확인 변수
            for (int k = 0; k < 4; k++) {   // 4방향 주위를 둘러보며 청소되지 않은 빈칸이 있는지 확인
                int nextX = c + dx[k];
                int nextY = r + dy[k];
                if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
                    if (area[nextY][nextX] == 0) {
                        check = true;
                    }
                }
            }

            // 3. 현재 칸의 주위 4칸 중 청소되지 않은 빈 칸이 있는 경우
            if (check) {
                d = (d + 3) % 4;    // 반시계 방향 90도 돌기 (0-북쪽, 1-동쪽, 2-남쪽, 3-서쪽)
                int nextX = c + dx[d];
                int nextY = r + dy[d];

                if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
                    if (area[nextY][nextX] == 0) {
                        r = nextY;
                        c = nextX;
                    }
                }
            }
            // 4. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
            else {        // check == false;
                int dd = (d + 2) % 4;       // 반대 방향
                int nextX = c + dx[dd];
                int nextY = r + dy[dd];

                if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
                    if (area[nextY][nextX] != 1) {      // 벽이 아니면 후진 (방향은 그대로 유지)
                        r = nextY;
                        c = nextX;
                    } else {                             // 벽이라면
                        run = false;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
