package org.example.hcu55.baekjoon.shortpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 알고스팟, 골드 IV
public class 알고스팟 {
    static int row, col;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());

        map = new int[row][col];
        visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        System.out.println(bfs(0, 0));
    }

    static int bfs(int startRow, int startCol) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(startRow, startCol, 0));
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            Node a = queue.poll();

            if (a.row == row - 1 && a.col == col - 1) {     // row, col 에 도달 했을 경우 반복문 탈출
                return a.breakWall;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = a.row + dx[i];
                int nextY = a.col + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) {       // row, col 범위 넘었을 시 넘김
                    continue;
                }
                if (visited[nextX][nextY]) {    // 이미 방문했을 시 넘김
                    continue;
                }
                if (map[nextX][nextY] == 0) {       // 빈방일 경우
                    queue.offer(new Node(nextX, nextY, a.breakWall));   // queue에 추가
                } else {
                    queue.offer(new Node(nextX, nextY, a.breakWall + 1));   // 벽일 경우 부술 벽 +1
                }
                visited[nextX][nextY] = true;
            }
        }
        return 0;
    }

    static class Node implements Comparable<Node> {
        int row, col, breakWall;

        Node(int row, int col, int breakWall) {
            this.row = row;
            this.col = col;
            this.breakWall = breakWall;
        }

        @Override
        public int compareTo(Node o) {
            return this.breakWall - o.breakWall;
        }
    }
}
