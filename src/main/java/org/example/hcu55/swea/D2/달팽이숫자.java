package org.example.hcu55.swea.D2;

import java.util.*;

public class 달팽이숫자 {
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt();
            int[][] snail = new int[N][N];

            int dir = 0;          // 방향 인덱스
            int x = 0, y = 0;     // 시작 좌표
            for (int i = 1; i <= N * N; i++) {
                snail[x][y] = i;

                int nextX = x + dx[dir];     // 다음 좌표
                int nextY = y + dy[dir];
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N || snail[nextX][nextY] != 0) {  // 범위 벗어나면
                    dir = (dir + 1) % 4;

                    nextX = x + dx[dir];    // 다음 좌표
                    nextY = y + dy[dir];
                }
                x = nextX;                  // 다음 값으로 변경
                y = nextY;
            }

            // 출력
            System.out.println("#" + testCase);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(snail[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
