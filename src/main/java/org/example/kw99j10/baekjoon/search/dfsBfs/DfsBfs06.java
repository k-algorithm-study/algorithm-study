package org.example.kw99j10.baekjoon.search.dfsBfs;

import java.util.Scanner;

/**
 * 적록 색약 - Gold V
 */
public class DfsBfs06 {
    static char[][] arr; // NxN의 구역
    static boolean[][] visit; //방문을 확인할 배열
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        arr = new char[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < s.length(); j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        int normal_count = 0; //적록색약이 아닌 사람이 봤을 때 구역의 수
        int redGreen_count = 0; //적록색약인 사람이 봤을 때 구역의 수

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (!visit[i][j]) {
                    normal_count += 1;
                    dfs(i, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                //적록색약의 경우: 적색과 녹색을 황색으로 변경
                if (arr[i][j] == 'G' || arr[i][j] == 'R') {
                    arr[i][j] = 'Y';
                }
            }
        }

        visit = new boolean[n][n]; //방문한 배열을 다시 초기화

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (!visit[i][j]) {
                    redGreen_count += 1;
                    dfs(i, j);
                }
            }
        }
        System.out.print(normal_count + " " + redGreen_count);
    }

    private static void dfs(int i, int j) {

        char c = arr[i][j];
        visit[i][j] = true;
        count += 1;

        //현재 좌표에서 이동할 수 있는 경우의 수(동, 서, 남, 북)
        int[][] xy = new int[][]{{i - 1, j}, {i + 1, j}, {i, j - 1}, {i, j + 1}};

        for (int[] ints : xy) {
            int distance_y = ints[0];
            int distance_x = ints[1];


            //같은 문자일 경우에만 dfs 진행
            if (distance_x >= 0 && distance_x <= arr[0].length - 1 &&
                    distance_y >= 0 && distance_y <= arr.length - 1) {
                if (arr[distance_y][distance_x] == c && !visit[distance_y][distance_x]) {
                    dfs(distance_y, distance_x);
                }
            }
        }
    }
}
