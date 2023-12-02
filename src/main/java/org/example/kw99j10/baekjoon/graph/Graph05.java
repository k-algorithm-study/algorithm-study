package org.example.kw99j10.baekjoon.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *  토마토 - Gold V
 */
public class Graph05 {
    static class Graph {
        int x;
        int y;
        int h; //높이
        int days;

        public Graph(int x, int y, int h, int days) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.days = days;
        }
    }
    static int [][][]tomato; //토마토의 상태를 담을 배열
    static Queue<Graph> queue; //좌표와 날짜를 담을 큐
    static int day; //모두 익을 때까지의 최소 날짜

    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int n; //세로
    static int m; //가로
    static int h; //높이

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt(); //가로
        n = sc.nextInt(); //세로
        h = sc.nextInt(); //상자 개수(높이)

        tomato = new int[n][m][h];
        queue = new LinkedList<>();

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    tomato[i][j][k] = sc.nextInt();

                    //익은 토마토를 큐에 담음(x좌표, y좌표, 높이, 익을 날짜)
                    if (tomato[i][j][k] == 1) {
                        queue.offer(new Graph(j, i, k, 0));
                    }
                }
            }
        }
        bfs();
    }
    private static void bfs() {

        day = 0;

        while (!queue.isEmpty()) {
            Graph graph = queue.poll();
            day = graph.days;

            for (int i = 0; i < 6; i++) {

                int nextX = graph.x + dx[i];
                int nextY = graph.y + dy[i];
                int nextZ = graph.h + dz[i];

                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n &&
                        nextZ >= 0 && nextZ < h) {

                    if (tomato[nextY][nextX][nextZ] == 0) {
                        tomato[nextY][nextX][nextZ] = 1;
                        queue.add(new Graph(nextX, nextY, nextZ, day + 1));
                    }
                }
            }
        }
        //익지 않은 토마토가 없다면 최소 날짜를 출력, 아니라면 -1을 출력
        System.out.println(getZero_totamo() == 0 ? day : -1);
    }
    private static int getZero_totamo() {
        int zero_totamo = 0; //익지 않은 토마토의 개수
        for (int[][] ints : tomato) {
            for (int[] anInt : ints) {
                for (int i : anInt) {
                    if (i == 0) {
                        zero_totamo += 1;
                    }
                }
            }
        }
        return zero_totamo;
    }
}
