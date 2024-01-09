package org.example.hcu55.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

// 전력망을 둘로 나누기, Programmers(Level 2)
public class 전력망을둘로나누기 {
    static int[][] arr;     // 안접 행렬 2차원 배열

    public int solution(int n, int[][] wires) {
        arr = new int[n + 1][n + 1];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {        // 인접 행렬 만들기
            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;
        }

        for (int i = 0; i < wires.length; i++) {        // 선 하나씩 끊으면서 bfs 탐색
            int a = wires[i][0];
            int b = wires[i][1];

            arr[a][b] = 0;      // 선 끊기
            arr[b][a] = 0;

            min = Math.min(min, bfs(a, n));     // bfs

            arr[a][b] = 1;      // 끊었던 선 복구
            arr[b][a] = 1;
        }
        return min;
    }

    static int bfs(int node, int n) {
        int count = 1;
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            visited[now] = true;
            for (int i = 1; i < n + 1; i++) {
                if (arr[now][i] == 1 && !visited[i]) {      // 연결되어있고 방문하지 않은 곳 탐색
                    queue.add(i);
                    count++;
                }
            }
        }
        return Math.abs(count - (n - count));       // count와 n - count 차이를 구하면됨
    }
}