package org.example.kw99j10.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 *  뱀 - Gold IV
 */
public class Implementation16 {
    static int n;
    static int[][] board;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static HashMap<Integer, String> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n + 1][n + 1];

        int k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a][b] = 1; //사과가 있는 곳
        }

        map = new HashMap<>();
        int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String c = st.nextToken();
            map.put(x, c);
        }

        boolean[][] visit = new boolean[n + 1][n + 1];
        ArrayDeque<int[]> snake = new ArrayDeque<>();
        snake.add(new int[]{1, 1});
        visit[1][1] = true;

        int dir = 0;
        int time = 0;

        while (true) {
            time++;

            int[] head = snake.getFirst();
            int currentX = head[0];
            int currentY = head[1];

            int nx = currentX + dx[dir];
            int ny = currentY + dy[dir];

            //벽이나 자기자신과 부딪힌 경우
            if (nx <= 0 || nx >= n + 1 || ny <= 0 || ny >= n + 1 || visit[nx][ny]) {
                break;
            }

            if (board[nx][ny] == 1) {
                board[nx][ny] = 0; //사과 먹음 -> 길이 증가
            } else {
                int[] last = snake.pollLast();
                visit[last[0]][last[1]] = false; //꼬리를 자름
            }

            visit[nx][ny] = true;
            snake.addFirst(new int[]{nx, ny});

            if (map.containsKey(time)) {
                dir = map.get(time).equals("L") ? (dir + 1) % 4 : (dir + 3) % 4;
            }
        }
        System.out.println(time);
    }
}
