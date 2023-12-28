package org.example.hcu55.baekjoon.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 나이트의 이동, 실버 I
public class 나이트의이동 {
    static int l;
    static int x1, x2, y1, y2;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, 2, 1, 2, -1, -2, -1, -2};
    static int[] dy = {2, 1, -2, -1, -2, -1, 2, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            l = sc.nextInt();

            arr = new int[l][l];
            visited = new boolean[l][l];

            x1 = sc.nextInt();      // 시작 좌표
            y1 = sc.nextInt();      // 시작 y좌표
            x2 = sc.nextInt();      // 원하는 위치
            y2 = sc.nextInt();

            bfs();
            System.out.println(arr[x2][y2]);
        }
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x1, y1});
        visited[x1][y1] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nx = now[0];
            int ny = now[1];

            for (int i = 0; i < 8; i++) {
                int nextX = nx + dx[i];
                int nextY = ny + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < l && nextY < l) {
                    if (!visited[nextX][nextY]) {
                        q.add(new int[]{nextX, nextY});
                        arr[nextX][nextY] = arr[nx][ny] + 1;
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
    }
}
