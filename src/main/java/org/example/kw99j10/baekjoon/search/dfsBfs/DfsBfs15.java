package org.example.kw99j10.baekjoon.search.dfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 *  탈출 - Gold IV
 */
public class DfsBfs15 {
    static int r, c, sx, sy, gx, gy;
    static char[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static ArrayList<int[]> water;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        water = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);

                if (map[i][j] == 'S') {
                    sx = i;
                    sy = j;
                    map[sx][sy] = '.';
                }

                if (map[i][j] == '*') {
                    water.add(new int[]{i, j});
                }

                if (map[i][j] == 'D') {
                    gx = i;
                    gy = j;
                }
            }
        }
        bfs();
        System.out.println(answer == Integer.MAX_VALUE ? "KAKTUS" : answer);
    }
    static void bfs() {
        ArrayDeque<int[]> gosum = new ArrayDeque<>();
        ArrayDeque<int[]> mul = new ArrayDeque<>();
        boolean[][] visit1 = new boolean[r][c];
        boolean[][] visit2 = new boolean[r][c];

        gosum.add(new int[]{sx, sy});
        visit1[sx][sy] = true;

        for (int i = 0; i < water.size(); i++) {
            int x = water.get(i)[0];
            int y = water.get(i)[1];
            mul.add(new int[]{x, y});
            visit2[x][y] = true;
        }

        int time = 0;
        while (!gosum.isEmpty()) {

            int len1 = mul.size();
            int len2 = gosum.size();

            for (int i = 0; i < len1; i++) {
                int[] current = mul.poll();
                int x = current[0];
                int y = current[1];

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                        continue;
                    }

                    if (visit2[nx][ny] || map[nx][ny] == 'X' || map[nx][ny] == 'D') {
                        continue;
                    }

                    map[nx][ny] = '*';
                    visit2[nx][ny] = true;
                    mul.add(new int[]{nx, ny});
                }
            }

            for (int i = 0; i < len2; i++) {
                int[] current = gosum.poll();
                int x = current[0];
                int y = current[1];

                if (x == gx && y == gy) {
                    answer = time;
                    return;
                }

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                        continue;
                    }

                    if (visit1[nx][ny] || map[nx][ny] == 'X' || map[nx][ny] == '*') {
                        continue;
                    }

                    visit1[nx][ny] = true;
                    gosum.add(new int[]{nx, ny});
                }
            }
            time++;
        }
    }
}
