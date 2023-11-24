package org.example.kw99j10.baekjoon.search.dfsBfs;

import java.util.*;

/**
 * 연구소 - Gold IV
 */
public class DfsBfs05 {
    static int [][]arr; //연구소를 담은 배열
    static int n; //연구소의 세로 길이
    static int m; //연구소의 가로 길이
    static int wall; //설치할 벽의 개수
    static Queue<int []>queue; //현재 좌표를 담을 큐
    static int max_safe; //안전 영역의 최대 크기

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dfs(wall); //3개의 벽을 세우는 경우의 수를 모두 구함
        System.out.println(max_safe);
    }

    private static void dfs(int wall) {

        //만약 3개의 벽을 다 세웠다면 해당 경우의 수로 bfs 수행
        //안전 영역의 크기의 최댓값을 구할 수 있는 경우의 수를 모두 탐색함

        if (wall == 3) {
            bfs();
            return;
        }

        //벽을 세움: 0 -> 1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    dfs(wall + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        queue = new LinkedList<>();

        //안전 영역 최댓값 비교를 위해 탐색할 임시 배열 생성
        int[][] tmp = new int[n][m];

        for (int i = 0; i < n; i++) {
            tmp[i] = Arrays.copyOf(arr[i], m);

            //바이러스가 있는 곳의 좌표를 큐에 담아 bfs 수행
            for (int j = 0; j < m; j++) {
                if (tmp[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int y = poll[0];
            int x = poll[1];

            int[][] xy = {{x - 1, y}, {x + 1, y}, {x, y - 1}, {x, y + 1}};

            for (int[] ints : xy) {

                int distance_x = ints[0];
                int distance_y = ints[1];

                if ((distance_x >= 0 && distance_x < m &&
                        distance_y >= 0 && distance_y < n) &&
                        tmp[distance_y][distance_x] == 0) {

                    tmp[distance_y][distance_x] = 2;
                    queue.add(new int[]{distance_y, distance_x});
                }
            }
        }

        int count = 0; //현재 안전 영역의 개수를 구함
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tmp[i][j] == 0) {
                    count += 1;
                }
            }
        }
        max_safe = Math.max(max_safe, count); //최대 안전 영역 갱신
    }
}