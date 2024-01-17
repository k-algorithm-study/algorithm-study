package org.example.hcu55.baekjoon.shortpath;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

// 녹색 옷 입은 애가 젤다지?, 골드 IV
public class 녹색옷입은애가젤다지 {
    static int[][] area;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int INF = 10000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int num = 1;
        while (true) {
            int N = sc.nextInt();
            if (N == 0) {
                break;
            }
            sb.append("Problem ").append(num++).append(": ");
            area = new int[N][N];
            for (int i = 0; i < N; i++) {       // 동굴 그리기
                for (int j = 0; j < N; j++) {
                    area[i][j] = sc.nextInt();
                }
            }
            sb.append(dijkstra(area, N)).append('\n');
        }
        System.out.println(sb);
    }

    public static int dijkstra(int[][] area, int n) {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);    // 우선순위 큐

        int[][] dijk = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dijk[i], INF);

        q.offer(new int[]{0, 0, area[0][0]});
        dijk[0][0] = area[0][0];               // 초기값 설정

        while (!q.isEmpty()) {
            int now[] = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n
                        && dijk[nextX][nextY] > dijk[nowX][nowY] + area[nextX][nextY]) {
                    dijk[nextX][nextY] = dijk[nowX][nowY] + area[nextX][nextY];
                    q.offer(new int[]{nextX, nextY, dijk[nextX][nextY]});
                }
            }
        }
        return dijk[n - 1][n - 1];
    }
}
