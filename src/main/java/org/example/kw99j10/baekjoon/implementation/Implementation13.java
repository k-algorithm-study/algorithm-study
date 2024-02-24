package org.example.kw99j10.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 로봇 청소기 - Gold V
 */
public class Implementation13 {
    static int n, m;
    static int[][] room;

    //0:북, 1:동, 2:남, 3:서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        room = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        room[r][c] = -1; //시작 위치를 청소
        count++;
        dfs(r, c, d); //현재 좌표에서 탐색 수행
        System.out.println(count);
    }

    static void dfs(int x, int y, int d) {

        //3번 작동
        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (room[nx][ny] == 0) {
                    room[nx][ny] = -1;
                    count++;
                    dfs(nx, ny, d);
                    return;
                }
            }
        }

        //2번 작동
        int b = (d + 2) % 4; //후진 탐색
        int bx = x + dx[b];
        int by = y + dy[b];

        if (room[bx][by] != 1) {
            dfs(bx, by, d);
        }
    }
}
