package org.example.kw99j10.baekjoon.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 토마토 - Gold V
 * 최소 날짜를 출력 -> 최솟값 -> bfs
 */
public class Graph03 {
    //토마토의 정보(x좌표, y좌표, 날짜)
    static class Graph {
        int x;
        int y;
        int days;

        public Graph(int x, int y, int days) {
            this.x = x;
            this.y = y;
            this.days = days;
        }
    }
    static int [][]tomato; //토마토의 상태를 담을 배열
    static  Queue<Graph> queue; //좌표와 날짜를 담을 큐

    static int day; //모두 익을 때까지의 최소 날짜

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt(); //상자의 세로
        int n = sc.nextInt(); //상자의 가로

        tomato = new int[n][m];
        queue = new LinkedList<>();

        for (int i = 0;i<tomato.length;i++) {
            for (int j = 0; j < tomato[i].length; j++) {
                tomato[i][j] = sc.nextInt();

                //익은 토마토를 큐에 담음
                if (tomato[i][j] == 1) {
                    queue.offer(new Graph(j, i, 0));
                }
            }
        }
        bfs();
    }
    private static void bfs() {
        day = 0;

        while (!queue.isEmpty()) {
            Graph graph = queue.poll();
            int x = graph.x;
            int y = graph.y;
            day = graph.days;

            int[][] xy = {{x - 1, y}, {x + 1, y}, {x, y - 1}, {x, y + 1}};

            for (int[] ints : xy) {
                int distance_x = ints[0];
                int distance_y = ints[1];

                if (distance_x >= 0 && distance_x < tomato[0].length &&
                        distance_y >= 0 && distance_y < tomato.length) {

                    //토마토가 안익었다면 -> 토마토를 익은 상태로
                    if (tomato[distance_y][distance_x] == 0) {
                        tomato[distance_y][distance_x] = 1;
                        queue.offer(new Graph(distance_x, distance_y, day + 1));
                    }
                }
            }
        }
        boolean b = true;
        for (int[] ints : tomato)
            for (int anInt : ints) {
                if (anInt == 0) {
                    b = false;
                    break;
                }
            }
        if (b) {
            System.out.println(day);
        }
        else{
            System.out.println(-1);
        }
    }
}
