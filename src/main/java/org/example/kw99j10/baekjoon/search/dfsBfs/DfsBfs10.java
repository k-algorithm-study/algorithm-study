package org.example.kw99j10.baekjoon.search.dfsBfs;

import java.util.Scanner;
/**
 * 촌수계산 - Silver II
 */
public class DfsBfs10 {
    static int n, a, b, m;
    static int[][] arr;
    static boolean[]visit;
    static int kinship = -1; //촌수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n + 1][n + 1];
        visit = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[x][y] = 1; //(부모, 자식)
            arr[y][x] = 1;
        }

        dfs(a, 0);
        System.out.println(kinship);
    }

    static void dfs(int start, int count) {
        visit[start] = true;
        if (start == b) {
            kinship = count;
            return; //목적지(촌수)에 도달했으면 dfs 종료
        }

        for (int i = 1; i <= n; i++) {
            if (!visit[i] && (arr[start][i] == 1 || arr[i][start] == 1)) {
                visit[i] = true;
                dfs(i, count + 1);
            }
        }
    }
}
