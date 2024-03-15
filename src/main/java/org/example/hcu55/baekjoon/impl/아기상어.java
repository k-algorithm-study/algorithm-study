package org.example.hcu55.baekjoon.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 아기 상어, 골드 III
public class 아기상어 {
    static int N;
    static int sharkX, sharkY, sharkSize = 2;
    static int time, eatCount = 0;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 9) {       // 상어 위치 저장
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0;          // 상어 자리 0으로 바꿔주기
                }
            }
        }

        int timeSum = 0;

        while (sharkGo()) {                   // 부모가 옮기지 않아도 될 때 계속 반복
            timeSum += time;
        }

        System.out.println(timeSum);
    }

    static boolean sharkGo() {
        time = 0;

        if (eatCount == sharkSize) {      // 상어 크기와 같은 수의 물고기를 먹을 때 마다 크기 1 증가
            eatCount = 0;
            sharkSize++;
        }

        boolean[][] visited = new boolean[N][N];

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(sharkX, sharkY, 0));
        visited[sharkX][sharkY] = true;

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int minTime = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Node a = queue.poll();

            if (a.time >= minTime)      // 최소 시간으로 물고기를 먹을 수 있는 시간을 넘으면 종료
                break;

            for (int i = 0; i < 4; i++) {
                int nextX = a.x + dx[i];
                int nextY = a.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N)
                    continue;
                if (visited[nextX][nextY])
                    continue;
                if (map[nextX][nextY] > sharkSize)
                    continue;

                // 아기 상어가 먹을 수 있는 물고기가 있는 칸에 들어옴
                if (map[nextX][nextY] > 0 && map[nextX][nextY] < sharkSize) {
                    if (nextX < minX) {
                        minX = nextX;
                        minY = nextY;
                        minTime = a.time + 1;
                    } else if (nextX == minX) {
                        if (nextY < minY) {
                            minY = nextY;
                            minTime = a.time + 1;
                        }
                    }
                }

                queue.offer(new Node(nextX, nextY, a.time + 1));
                visited[nextX][nextY] = true;
            }
        }

        if (minTime == Integer.MAX_VALUE)
            return false;
        else {
            sharkX = minX;
            sharkY = minY;
            eatCount++;
            time = minTime;
            map[sharkX][sharkY] = 0;

            return true;
        }
    }

    static class Node {
        int x, y, time;

        Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}

