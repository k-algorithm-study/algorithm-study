package org.example.kw99j10.baekjoon.graph;

import java.util.Scanner;

/**
 *  안전 영역 - Silver I
 */
public class Graph06 {
    static int[][] arr;
    static boolean[][] visit;
    static int n;
    static int max_total; //안전한 영역의 개수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n][n];

        int min = 101; //물에 잠기는 최저 높이
        int max = 0; //물이 잠기는 최고 높이

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                min = Math.min(min, arr[i][j]);
                max = Math.max(max, arr[i][j]);
            }
        }

        //배열의 모든 요소가 같은 경우 물에 잠기지 않음
        if (min == max) {
            System.out.println(1);
            return;
        }

        for (int h = min; h <= max; h++) {

            int total = 0; //안전한 영역의 개수
            visit = new boolean[n][n]; //높이마다 방문 배열 초기화

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    //현재 기준 높이보다 높은 지역을 dfs 수행
                    if (arr[i][j] > h && !visit[i][j]) {
                        total += 1;
                        dfs(i, j, h);
                    }
                }
            }
            max_total = Math.max(max_total, total);
        }
        System.out.println(max_total);
    }

    static void dfs(int i, int j,int h) {

        //현재 좌표에서 이동할 수 있는 경우의 수(동, 서, 남, 북)
        int[][] xy = new int[][]{{i - 1, j}, {i + 1, j}, {i, j - 1}, {i, j + 1}};

        for (int[] ints : xy) {
            int distance_y = ints[0];
            int distance_x = ints[1];

            if (distance_x >= 0 && distance_x < n &&
                    distance_y >= 0 && distance_y < n) {
                if (arr[distance_y][distance_x] > h && !visit[distance_y][distance_x]) {
                    visit[distance_y][distance_x] = true;
                    dfs(distance_y, distance_x, h);
                }
            }
        }
    }
}
