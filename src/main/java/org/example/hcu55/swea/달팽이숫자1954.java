package org.example.hcu55.swea;

import java.util.Scanner;

public class 달팽이숫자1954 {
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int size = sc.nextInt();
            int[][] snail = new int[size][size];

            int x = 0, y = 0, dir = 0, num = 1;
            while (num <= size * size) {
                snail[x][y] = num++;
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= size || ny < 0 || ny >= size || snail[nx][ny] != 0) {
                    dir = (dir + 1) % 4;
                    nx = x + dx[dir];
                    ny = y + dy[dir];
                }
                x = nx;
                y = ny;
            }

            System.out.println("#" + test_case);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.print(snail[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
