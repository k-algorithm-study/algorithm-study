package org.example.hcu55.baekjoon.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 숨박꼭질, 실버 I
public class 숨박꼭질 {
    static int[] dx = {-1, 1, 2};       // 수빈이가 이동할 수 있는 종류
    static int N;   // 수빈이 위치
    static int K;   // 동생 위치
    static int[] point = new int[100001];   // 점 위치 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        if (N == K) {
            System.out.println(0);  // 시작부터 위치가 같으면 0초 리턴
        } else {
            bfs(N);
        }
    }

    static void bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        point[num] = 1;     // 시작 위치를 1초부터 시작

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 2) {
                    next = now * dx[i];
                } else {
                    next = now + dx[i];
                }

                if (next == K) {    // 동생을 찾음
                    System.out.println(point[now]);
                    return;
                }

                if (next >= 0 && next < point.length && point[next] == 0) {
                    queue.add(next);
                    point[next] = point[now] + 1;   // 다음 위치 1초 추가
                }
            }
        }
    }
}
