package org.example.kw99j10.baekjoon.search.dfsBfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 영역 구하기 - Silver I
 */
public class DfsBfs09 {
    static int n, m, k;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        k = sc.nextInt();

        map = new int[m][n];

        //k개의 직사각형 좌표
        for (int i = 0; i < k; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();

            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    map[j][k] = 1; //해당 영역을 색칠
                }
            }
        }

        var list = new ArrayList<Integer>(); //넓이를 담을 리스트

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    count = 0;
                    dfs(i, j);
                    list.add(count);
                }
            }
        }

        Collections.sort(list); //각 영역 넓이 오름차순 정렬
        System.out.println(list.size());
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
    static void dfs(int i, int j) {

        map[i][j] = -1; //방문한 영역을 표시
        count += 1;

        for (int s = 0; s < 4; s++) {
            int move_x = i + dx[s];
            int move_y = j + dy[s];

            if (move_x >= 0 && move_x < m && move_y >= 0 && move_y < n) {
                if (map[move_x][move_y] == 0) {
                    dfs(move_x, move_y);
                }
            }
        }
    }
}
