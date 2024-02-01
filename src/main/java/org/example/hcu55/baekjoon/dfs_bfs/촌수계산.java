package org.example.hcu55.baekjoon.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 촌수계산, 실버 II
public class 촌수계산 {
    static int n, m, person1, person2;
    static int[][] tree;
    static int[] dist;      // 촌수 배열
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();           // 전체 사람 수
        person1 = sc.nextInt();     // 촌수 비교 대상 1
        person2 = sc.nextInt();     // 촌수 비교 대상 2
        m = sc.nextInt();           // 부모 자식 관계 개수
        tree = new int[n + 1][n + 1];
        dist = new int[n + 1];

        for (int i = 0; i < m; i++) {    // 2차원 배열로 tree 생성
            int x = sc.nextInt();
            int y = sc.nextInt();

            tree[x][y] = 1;
            tree[y][x] = 1;
        }

        bfs(person1, person2);

        if (dist[person2] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(dist[person2]);
        }
    }

    public static void bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == end) {
                break;
            }
            for (int i = 1; i <= n; i++) {
                if (tree[now][i] == 1 && dist[i] == 0) {
                    dist[i] = dist[now] + 1;
                    queue.add(i);
                }
            }
        }
    }
}
