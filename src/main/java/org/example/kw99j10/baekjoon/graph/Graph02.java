package org.example.kw99j10.baekjoon.graph;

import java.util.*;

/**
 * 단지번호 붙이기 - Silver I
 */
public class Graph02 {
    static int[][] map; //입력 받을 지도 배열
    static int count; //각 단지 수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();//지도의 크기

        map = new int[n][n]; //N X N 크기의 지도

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < s.length(); j++) {
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        int total = 0; //총 단지 수
        var a = new ArrayList<Integer>(); //각 단지를 담을 리스트

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) {

                    count = 0;
                    total += 1;
                    dfs(i, j);

                    a.add(count);
                }
            }
        }

        System.out.println(total);
        Collections.sort(a);
        for (Integer integer : a) {
            System.out.println(integer);
        }
    }

    static void dfs(int i, int j) {

        //방문한 위치는 0으로 초기화 한 후 단지 수 증가
        map[i][j] = 0;
        count += 1;

        //현재 좌표에서 이동할 수 있는 경우의 수(동, 서, 남, 북)
        int[][] xy = new int[][]{{i - 1, j}, {i + 1, j}, {i, j - 1}, {i, j + 1}};

        for (int[] ints : xy) {
            int distance_y = ints[0];
            int distance_x = ints[1];

            // 이동한 좌표가 미로 안에 있어야 하며,
            // 그 좌표는 1(이동할 수 있는 칸)이어야 함
            if (distance_x >= 0 && distance_x <= map[0].length - 1 &&
                    distance_y >= 0 && distance_y <= map.length - 1) {
                if (map[distance_y][distance_x] == 1) {
                    dfs(distance_y, distance_x);
                }
            }
        }
    }
}
