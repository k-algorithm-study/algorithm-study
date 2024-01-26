package org.example.kw99j10.baekjoon.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *  영역 구하기 - Silver I
 */
public class Graph10 {
    static int n, m;
    static int[][] square;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        int k = sc.nextInt();

        square = new int[m][n];
        visit = new boolean[m][n];

        for (int i = 0; i < k; i++) {
            int a = sc.nextInt(); //x 좌표
            int b = sc.nextInt(); //그리는 직사각형의 좌표 //y좌표

            int c = sc.nextInt();
            int d = sc.nextInt();

            for (int j = b; j < d; j++) {
                for (int s = a; s < c; s++) {
                    square[j][s] = 1; //직사각형을 채움
                }
            }
        }

        ArrayList<Integer> lists = new ArrayList<>();//영역을 담을 리스트

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && square[i][j] == 0) {
                    count = 1; //최소 하나의 영역
                    dfs(i, j);
                    lists.add(count);
                }
            }
        }

        Collections.sort(lists); //영역 넓이 오름차순 정렬
        System.out.println(lists.size()); //영역의 개수
        for (Integer list : lists) {
            System.out.print(list + " ");
        }
    }
    static void dfs(int i, int j) {
        visit[i][j] = true;

        for (int d = 0; d < 4; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];

            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if (!visit[nx][ny] && square[nx][ny] == 0) {
                    dfs(nx, ny);
                    count += 1;
                }
            }
        }
    }
}
