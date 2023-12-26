package org.example.kw99j10.baekjoon.search.shortestPath;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 알고스팟 - Gold IV
 */
public class shortestPath07 {
    static int n; //미로의 세로
    static int m; //미로의 가로
    static int[][] maze; //주어진 미로
    static boolean[][] visit; //방문을 확인할 배열
    static class Node {
        //큐에 담을 정보(x좌표, y좌표, 뚫을 벽의 개수)
        int x;
        int y;
        int count;
        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();

        maze = new int[n][m]; //0은 빈방, 1은 벽을 의미
        visit = new boolean[n][m]; //방문 배열 초기화

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                maze[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        bfs(0, 0); //원점에서 이동 시작
    }
    static void bfs(int i, int j) {

        //최단 경로(최소 부수기 위한 벽의 개수)를 위한 우선순위 큐
        PriorityQueue<Node> queue = new PriorityQueue<>((Comparator.comparingInt(o -> o.count)));

        queue.add(new Node(i, j, 0));
        visit[i][j] = true; //시작점 초기화

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            int x = node.x;
            int y = node.y;

            //미로의 끝에 도달했을 때, 벽을 부순 개수를 출력
            if (x == m - 1 && y == n - 1) {
                System.out.println(node.count);
                break;
            }

            int[][] xy = new int[][]{{x - 1, y}, {x + 1, y}, {x, y - 1}, {x, y + 1}};

            for (int[] ints : xy) {
                int distance_x = ints[0];
                int distance_y = ints[1];

                if (distance_x >= 0 && distance_x < m &&
                        distance_y >= 0 && distance_y < n) {

                    //빈 방은 그냥 지나가고 벽이라면 뚫고 지나감 && 방문 확인 필요
                    if (!visit[distance_y][distance_x]) {
                        if (maze[distance_y][distance_x] == 0) {
                            queue.add(new Node(distance_x, distance_y, node.count));
                        } else {
                            queue.add(new Node(distance_x, distance_y, node.count + 1));
                        }
                        visit[distance_y][distance_x] = true;
                    }
                }
            }
        }
    }
}
