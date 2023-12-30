package org.example.kw99j10.baekjoon.graph;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 나이트의 이동 - Silver I
 */

public class Graph07 {
    static int[][] arr; //체스판
    static boolean[][] visit; //체스판 방문 확인 여부
    static int goal_x, goal_y; //이동하려는 칸
    static int l; //체스판의 한 변의 길이

    //이동할 수 있는 좌표 경우의 수
    static int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
    static int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            l = sc.nextInt(); //한 변의 길이
            arr = new int[l][l];
            visit = new boolean[l][l];

            int start_x = sc.nextInt(); //현재 있는 칸
            int start_y = sc.nextInt();

            goal_x = sc.nextInt();
            goal_y = sc.nextInt();

            bfs(start_x, start_y);
        }
    }
    static void bfs(int start_x, int start_y) {
        LinkedList<int[]> queue = new LinkedList<>();

        visit[start_y][start_x] = true;
        queue.add(new int[]{start_x, start_y});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            if (x == goal_x && y == goal_y) {
                break; //목적지에 도달하면 반복문 종료
            }

            for (int i = 0; i < dx.length; i++) {
                int distance_x = x + dx[i];
                int distance_y = y + dy[i];

                //현재 칸에서 이동가능한 거리: 현재 이동 횟수 +1
                if (distance_y >= 0 && distance_y < l &&
                    distance_x >= 0 && distance_x < l) {
                    if (!visit[distance_y][distance_x] && arr[distance_y][distance_x] == 0) {
                        visit[distance_y][distance_x] = true;
                        arr[distance_y][distance_x] = arr[y][x] + 1;
                        queue.add(new int[]{distance_x, distance_y});
                    }
                }
            }
        }
        System.out.println(arr[goal_y][goal_x]);
    }
}
