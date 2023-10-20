package org.example.kw99j10.baekjoon.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 미로 탐색 - Silver I
 */
public class Graph01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int [][] road = new int[n][m]; // N x M 크기의 미로
        for (int i = 0; i < n; i++) {
            String s = sc.next();

            for (int j = 0; j < s.length(); j++) {
                road[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        int[][] dp = new int[road.length][road[0].length]; //최소 칸 수를 담을 배열
        boolean[][] visit = new boolean[n][m]; //방문했는 지 확인할 배열
        Queue<int[]> queue = new LinkedList<>(); //현재 좌표와 최소 칸 수를 담을 큐

         //시작점 초기화
        visit[0][0] = true;
        queue.add(new int[]{0, 0, 1});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0]; //현재 미로의 x 좌표
            int y = poll[1]; //현재 미로의 y 좌표

            int distance = poll[2];//현재 좌표까지의 최단 거리 (최소 칸 수)
            dp[y][x] = distance;

            //현재 좌표에서 이동할 수 있는 경우의 수(동, 서, 남, 북)
            int[][] xy = new int[][]{{x - 1, y}, {x + 1, y}, {x, y - 1}, {x, y + 1}};

            for (int[] ints : xy) {

                int distance_x = ints[0];
                int distance_y = ints[1];

                // 이동한 좌표가 미로 안에 있어야 하며,
                // 그 좌표는 1(이동할 수 있는 칸)이어야 하고,
                // 방문하지 않았어야 거리를 갱신함
                if ((distance_x >= 0 && distance_x <= dp[0].length - 1 &&
                        distance_y >= 0 && distance_y <= dp.length - 1) &&
                        road[distance_y][distance_x] == 1 &&
                        !visit[distance_y][distance_x]) {

                    visit[distance_y][distance_x] = true;
                    queue.add(new int[]{distance_x, distance_y, distance + 1});
                }
            }
        }
        System.out.println(dp[dp.length - 1][dp[0].length - 1]);
    }
}
