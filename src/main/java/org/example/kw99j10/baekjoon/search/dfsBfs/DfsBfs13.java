package org.example.kw99j10.baekjoon.search.dfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *  빙산 - Gold IV
 */
public class DfsBfs13 {
    static int n, m;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int area, time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            visit = new boolean[n][m];
            ArrayList<Integer> total = new ArrayList<>(); //분리된 빙산의 개수
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visit[i][j] && arr[i][j] != 0) {
                        area = 0;
                        dfs(i, j);
                        total.add(area);
                    }
                }
            }

            if (total.size() >= 2) {
                break;
            }
            if (total.isEmpty()) {
                time = 0;
                break;
            }

            bfs();
            time++;
        }
        System.out.println(time);
    }

    private static void bfs() {

        ArrayList<int[]> lists = new ArrayList<>();
        boolean[][] visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != 0) {
                    lists.add(new int[]{i, j});
                    visit[i][j] = true;
                }
            }
        }

        ArrayDeque<int[]> queue = new ArrayDeque<>(lists);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny]) {
                    continue;
                }

                int nv = arr[nx][ny];

                if (nv == 0) {
                    if (arr[x][y] > 0) {
                        arr[x][y] -= 1;
                    }
                }
            }
        }
    }

    static void dfs(int x, int y) {
        area++;
        visit[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }
            if (arr[nx][ny] != 0 && !visit[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}
