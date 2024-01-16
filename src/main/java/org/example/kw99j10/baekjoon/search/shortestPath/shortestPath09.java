package org.example.kw99j10.baekjoon.search.shortestPath;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 녹색 옷 입은 애가 젤다지? - Gold IV
 */
public class shortestPath09 {
    static int n;
    static int[][] cave;
    static boolean[][] visit;
    static int[][] roopy;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    static int min;
    static final int INF = 999999;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int count = 1;
        while (true) {
            n = sc.nextInt();

            if (n == 0) {
                break;
            }
            cave = new int[n][n];
            visit = new boolean[n][n];
            roopy = new int[n][n];

            for (int i = 0; i < n; i++) {
                Arrays.fill(roopy[i], INF);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    cave[i][j] = sc.nextInt();
                }
            }
            bfs();
            System.out.println("Problem " + count + ": " + roopy[n - 1][n - 1]);
            count += 1;
        }
    }
    static void bfs() {
        var queue = new LinkedList<int[]>();
        visit[0][0] = true;
        roopy[0][0] = cave[0][0];
        queue.add(new int[] { 0, 0 });

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                //다익스트라 알고리즘
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (!visit[nx][ny]) {
                        if (roopy[nx][ny] > roopy[x][y] + cave[nx][ny]) {
                            roopy[nx][ny] = roopy[x][y] + cave[nx][ny];
                            queue.add(new int[] { nx, ny });
                        }
                    }
                }
            }
        }
    }
}

