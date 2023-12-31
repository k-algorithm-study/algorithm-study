package org.example.kw99j10.baekjoon.graph;

import java.util.Scanner;

/**
 * 알파벳 - Gold IV
 */
public class Graph08 {
    static int r, c; //세로 r칸, 가로 c칸
    static char[][] arr; // R x C 모양의 보드
    static boolean[] visit = new boolean[26]; //알파벳 방문을 확인할 배열
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int max; //말의 최대 칸 수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();
        c = sc.nextInt();

        arr = new char[r][c];

        for (int i = 0; i < r; i++) {
            String s = sc.next();
            for (int j = 0; j < s.length(); j++) {
                arr[i][j] = s.charAt(j); //보드 초기화
            }
        }

        if (r == 1 && c == 1) {
            System.out.println(1);
            return;
        }

        dfs(0, 0, 0); //시작 좌표와 칸을 지날 수 있는 개수
        System.out.println(max);
    }
    static void dfs(int x, int y, int count) {

        //같은 알파벳 칸이 나온 경우 더 이상 움직일 수 없으므로 최대 칸 수를 리턴
        if (visit[arr[y][x] - 65]) {
            max = Math.max(max, count);
            return;
        }

        visit[arr[y][x] - 65] = true;
        for (int i = 0; i < dx.length; i++) {
            int distance_x = x + dx[i];
            int distance_y = y + dy[i];

            if (distance_y >= 0 && distance_y < r &&
                    distance_x >= 0 && distance_x < c) {
                dfs(distance_x, distance_y, count + 1);
            }
        }
        visit[arr[y][x] - 65] = false; //현재 좌표를 방문 후 방문을 초기화*/
    }
}
