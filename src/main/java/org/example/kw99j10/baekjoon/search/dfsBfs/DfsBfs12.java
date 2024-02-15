package org.example.kw99j10.baekjoon.search.dfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 인구 이동 - Gold IV
 */
public class DfsBfs12 {
    static int n, l, r;
    static int[][] map;
    static boolean[][] visit;
    static boolean moveAble;
    static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int days;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        move();
        System.out.println(days);
    }
    static void move() {
        while (true) {
            moveAble = false;
            visit = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visit[i][j]) {
                        bfs(i, j);
                    }
                }
            }
            if (!moveAble) {
                break; //다 방문했으면 인구 이동 종료
            }
            else{
                days += 1; //방문할 곳이 남았으므로 인구 이동을 진행
            }
        }
    }

    static void bfs(int i, int j) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        ArrayList<int[]> union = new ArrayList<>(); //연합을 담을 리스트
        queue.add(new int[]{i, j});
        union.add(new int[]{i, j});
        visit[i][j] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + move[d][0];
                int ny = y + move[d][1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    int ans = Math.abs(map[nx][ny] - map[x][y]);
                    if (ans >= l && ans <= r && !visit[nx][ny]) {
                        visit[nx][ny] = true;
                        moveAble = true;
                        queue.add(new int[]{nx, ny});
                        union.add(new int[]{nx, ny});
                    }
                }
            }
        }
        int sum = 0;
        for (int z = 0; z < union.size(); z++) {
            int[] current = union.get(z);
            sum += map[current[0]][current[1]];
        }

        for (int z = 0; z < union.size(); z++) {
            int[] current = union.get(z);
            map[current[0]][current[1]] = sum / union.size();
        }
    }
}
