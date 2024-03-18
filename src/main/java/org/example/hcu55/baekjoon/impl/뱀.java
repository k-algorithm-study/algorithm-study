package org.example.hcu55.baekjoon.impl;

import java.util.*;

// 뱀, 골드 IV
public class 뱀 {
    static int N, d = 0;
    static int[][] map;
    static Map<Integer, String> moveInfo;       // 시간, 방향
    static int[] dx = {1, 0, -1, 0};            // 오른쪽, 아래, 왼쪽, 위 순서 -> 시계 방향
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();            // 보드 크기
        int K = sc.nextInt();        // 사과 개수
        map = new int[N][N];
        moveInfo = new HashMap<>();

        for (int i = 0; i < K; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            map[a][b] = 1;              // 사과 위치 1로 표시
        }

        int L = sc.nextInt();                   // 뱀의 방향 변환 횟수
        for (int i = 0; i < L; i++) {
            int time = sc.nextInt();
            String direction = sc.next();
            moveInfo.put(time, direction);      // 뱀의 방향 변환 정보 저장
        }

        solve();
    }

    static void solve() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        int time = 0;
        int nowX = 0;
        int nowY = 0;

        while (true) {
            int nextX = nowX + dx[d];
            int nextY = nowY + dy[d];
            time++;

            // 벽 부딪힘
            if (nextX < 0 || nextY < 0 || nextX > N - 1 || nextY > N - 1) {
                break;
            }

            // 몸통 부딪힘
            if (queue.contains(nextY * N + nextX)) {
                break;
            }

            // 안 부딪히면 뱀 이동시작
            if (map[nextY][nextX] == 1) {
                map[nextY][nextX] = 0;
                queue.add(nextY * N + nextX);
            } else {
                queue.add(nextY * N + nextX);
                queue.poll();       // 꼬리 위치 삭제
            }

            // 방향 전환
            if (moveInfo.containsKey(time)) {
                String direction = moveInfo.get(time);      // 방향 추출
                if (direction.equals("D")) {        // 오른쪽 회전
                    d += 1;                         // 시계 방향 회전
                    if (d == 4) d = 0;
                } else if (direction.equals("L")) {
                    d -= 1;                         // 반시계 방향 회전
                    if (d == -1) d = 3;
                }
            }
            nowX = nextX;
            nowY = nextY;
        }

        System.out.println(time);
    }
}
