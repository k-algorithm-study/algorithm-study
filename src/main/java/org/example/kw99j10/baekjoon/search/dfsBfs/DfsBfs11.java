package org.example.kw99j10.baekjoon.search.dfsBfs;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * 숨바꼭질 3 - Gold V
 * */
public class DfsBfs11 {
    static int n, k;
    static boolean[] visit;
    static int min = 100001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); //현재 수빈이의 위치
        k = sc.nextInt();
        visit = new boolean[100001]; //100000까지 좌표의 길이

        bfs();
        System.out.println(min);
    }

    static void bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{n, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            visit[current[0]] = true;
            if (current[0] == k) {
                min = Math.min(min, current[1]);
            }

            //순간이동의 경우 시간 x
            if (current[0] * 2 <= 100000 && !visit[current[0] * 2]) {
                queue.add(new int[]{current[0] * 2, current[1]});
            }

            if (current[0] + 1 <= 100000 && !visit[current[0] + 1]) {
                queue.add(new int[]{current[0] + 1, current[1] + 1});
            }

            if (current[0] - 1 >= 0 && !visit[current[0] - 1]) {
                queue.add(new int[]{current[0] - 1, current[1] + 1});
            }
        }
    }
}
