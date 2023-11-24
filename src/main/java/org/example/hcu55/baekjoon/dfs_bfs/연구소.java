package org.example.hcu55.baekjoon.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 연구소, 골드 IV
public class 연구소 {
    private static int N, M;            // 연구소 크기
    private static int[][] map;         // 연구소 맵
    private static int[][] virus_map;   // 연구소 맵 복사 맵
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int maxSafeArea = Integer.MIN_VALUE;

    static class virus {    // 바이러스 객체
        int x, y;

        virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        virus_map = new int[N][M];

        for (int i = 0; i < N; i++) {       // 연구소 맵 저장
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        DFS(0);     // 벽 3개 세우기 dfs 살행

        System.out.println(maxSafeArea);
    }

    public static void DFS(int wall) {
        if (wall == 3) {        // 벽 3개 세우고 바이러스 퍼뜨리기 확인
            BFS();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    DFS(wall + 1);  // 벽 세우고 다시 재귀
                    map[i][j] = 0;     // 원상 복구
                }
            }
        }
    }

    public static void BFS() {
        Queue<virus> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    queue.add(new virus(i, j));
                }
            }
        }

        for (int i = 0; i < N; i++) {       // 벽 있는 원본 연구소 맵 복사
            virus_map[i] = map[i].clone();
        }

        while (!queue.isEmpty()) {
            virus now = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nextX = now.x + dx[k];
                int nextY = now.y + dy[k];

                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
                    if (virus_map[nextX][nextY] == 0) {
                        queue.add(new virus(nextX, nextY));
                        virus_map[nextX][nextY] = 2;
                    }
                }
            }
        }
        safeAreaResult(virus_map);
    }

    public static void safeAreaResult(int[][] virus_map) {  // 안전한 곳 개수 구하기
        int safeZone = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virus_map[i][j] == 0) {
                    safeZone++;
                }
            }
        }
        if (maxSafeArea < safeZone) {
            maxSafeArea = safeZone;
        }
    }
}
