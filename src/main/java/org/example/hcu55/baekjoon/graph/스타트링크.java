package org.example.hcu55.baekjoon.graph;

import java.util.*;

// 스타트링크, 실버 I
public class 스타트링크 {
    static int f, s, g, u, d;
    static int visited[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        f = sc.nextInt();   // 건물 높이
        s = sc.nextInt();   // 강호 위치
        g = sc.nextInt();   // 스타트링크 높이
        u = sc.nextInt();   // 올라가는 층
        d = sc.nextInt();   // 내려가는 층
        visited = new int[f + 1];

        bfs(f, s, g, u, d);
    }

    static void bfs(int f, int s, int g, int u, int d) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = 1;     //시작점 방문함 (1번 누른것으로 간주)

        while (!queue.isEmpty()) {
            int current = queue.poll();       // 현재위치

            if (current == g) {               // 현재위치 = 가야할 곳
                System.out.println(visited[current] - 1);   //맨 처음 버튼 누른것처럼 한거 뺀다
            }

            if (current + u <= f && visited[current + u] == 0) {  // 올라갈 수 있고 방문X
                visited[current + u] = visited[current] + 1;
                queue.add(current + u);
            }

            if (current - d > 0 && visited[current - d] == 0) {   // 내려갈 수 있고 방문X
                visited[current - d] = visited[current] + 1;
                queue.add(current - d);
            }
        }

        if (visited[g] == 0)        // 스타트링크 층에 갈 수 없음
            System.out.println("use the stairs");
    }
}