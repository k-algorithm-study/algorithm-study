package org.example.hcu55.baekjoon.dfs_bfs;

import java.util.Scanner;

// 적록색약, 골드 V
public class 적록색약 {
    private static int N;
    private static char[][] picture;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        picture = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {   // 그림 배열 저장
            String input = sc.next();
            for (int j = 0; j < N; j++) {
                picture[i][j] = input.charAt(j);
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {     // 정상인 경우
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        int norma = count;
        count = 0;                      // 다시 개수 0으로 초기화
        visited = new boolean[N][N];    // 방문 배열 초기화

        for (int i = 0; i < N; i++) {   // 적록색약인 경우 G를 R로 변경
            for (int j = 0; j < N; j++) {
                if (picture[i][j] == 'G') {
                    picture[i][j] = 'R';
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        int abnormal = count;
        System.out.println(norma + " " + abnormal);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        char now_color = picture[x][y];
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {
                if (!visited[nextX][nextY] && picture[nextX][nextY] == now_color) {
                    dfs(nextX, nextY);
                }
            }
        }
    }
}