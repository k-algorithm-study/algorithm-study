package org.example.hcu55.baekjoon.graph;

import java.util.Arrays;
import java.util.Scanner;

// 단지번호붙이기, 실버 I
public class 단지번호붙이기 {
    static int n;
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    static int[] house = new int[25 * 25];
    static int houseNum = 0;   // 집 개수
    static boolean[][] visited = new boolean[25][25];   // 방문여부
    static int[][] map = new int[25][25];   //지도

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        map = new int[n][n];
        visited = new boolean[n][n];

        // 입력
        for (int i = 0; i < n; i++) {
            String input = sc.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    houseNum++;
                    dfs(i, j);
                }
            }
        }

        Arrays.sort(house);
        System.out.println(houseNum);

        for (int i = 0; i < house.length; i++) {
            if (house[i] == 0) {
            } else {
                System.out.println(house[i]);
            }
        }
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        house[houseNum]++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}

