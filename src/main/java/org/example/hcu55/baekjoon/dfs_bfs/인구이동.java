package org.example.hcu55.baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 인구 이동, 골드 IV
public class 인구이동 {
    static int N, L, R;
    static int[][] area;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static ArrayList<Node> unionArea;       // 인구 이동에 필요한 노드 리스트
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        area = new int[N][N];

        for (int i = 0; i < N; i++) {                   // 나라 입력 받기
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        move();

        System.out.println(result);

    }

    public static void move() {
        result = 0;

        while (true) {
            boolean isMove = false;
            visited = new boolean[N][N];        // 새로 탐색 시 방문 배열 초기화

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        int sum = bfs(i, j);        // bfs 탐색으로 연합의 합 가져오기

                        if (unionArea.size() > 1) {
                            int avg = sum / unionArea.size();       // 소수점 그냥 버림
                            for(Node n : unionArea) {
                                area[n.x][n.y] = avg;
                            }
                            isMove = true;
                        }
                    }
                }
            }
            if (!isMove) {
                break;
            }
            result++;
        }
    }

    public static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        unionArea = new ArrayList<>();

        queue.add(new Node(x, y));
        unionArea.add(new Node(x, y));
        visited[x][y] = true;

        int sum = area[x][y];

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nextX = now.x + dx[k];
                int nextY = now.y + dy[k];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && !visited[nextX][nextY]) {
                    int diff = Math.abs(area[now.x][now.y] - area[nextX][nextY]);

                    if (diff >= L && diff <= R) {
                        queue.add(new Node(nextX, nextY));
                        unionArea.add(new Node(nextX, nextY));
                        sum += area[nextX][nextY];
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
        return sum;
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
