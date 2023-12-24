package org.example.kw99j10.baekjoon.search.dfsBfs;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 섬의 개수 - Silver II
 */
public class DfsBfs07 {
    static int[][] island; //섬의 크기
    static int count; //섬의 개수

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        var a = new ArrayList<Integer>(); //섬의 개수를 담을 리스트

        while (true) {
            int w = sc.nextInt();
            int h = sc.nextInt();

            if (w == 0 && h == 0) {
                break; //종료 조건
            }

            island = new int[h][w];

            //1은 땅, 0은 바다
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    island[i][j] = sc.nextInt();
                }
            }

            count = 0; //새로운 지도가 주어질 때마다 count를 초기화

            //1이라면 땅이므로 바다가 나올 때까지 dfs 수행
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (island[i][j] == 1) {
                        count += 1;
                        dfs(i, j);
                    }
                }
            }
            a.add(count); //현재 지도의 섬의 개수를 담음
        }
        for (Integer integer : a) {
            System.out.println(integer);
        }
    }

    private static void dfs(int i, int j) {
        island[i][j] = 0;

        //현재 좌표에서 이동할 수 있는 경우의 수(동, 서, 남, 북) + 대각선 추가
        int[][] xy = new int[][]{{i - 1, j}, {i + 1, j}, {i, j - 1}, {i, j + 1},
                {i + 1, j + 1}, {i + 1, j - 1}, {i - 1, j + 1}, {i - 1, j - 1}};

        for (int[] ints : xy) {
            int distance_y = ints[0];
            int distance_x = ints[1];

            if (distance_x >= 0 && distance_x <= island[0].length - 1 &&
                    distance_y >= 0 && distance_y <= island.length - 1) {
                if (island[distance_y][distance_x] == 1) {
                    dfs(distance_y, distance_x);
                }
            }
        }
    }
}
