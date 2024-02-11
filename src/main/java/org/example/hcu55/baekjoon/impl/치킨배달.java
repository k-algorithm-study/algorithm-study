package org.example.hcu55.baekjoon.impl;

import java.util.ArrayList;
import java.util.Scanner;

// 치킨 배달, 골드 V
public class 치킨배달 {
    static int N, M, result;
    static int[][] area;
    static ArrayList<Node> house = new ArrayList<>();       // 집 위치 저장 리스트
    static ArrayList<Node> chicken = new ArrayList<>();     // 치킨집 위치 저장 리스트
    static boolean[] visited;                               // 뽑은 치킨집 체크

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        area = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                area[i][j] = sc.nextInt();

                if (area[i][j] == 1) {              // 집 좌표 값 저장
                    house.add(new Node(i, j));
                } else if (area[i][j] == 2) {       // 치킨집 좌표 값 저장
                    chicken.add(new Node(i, j));
                }
            }
        }

        result = Integer.MAX_VALUE;
        visited = new boolean[chicken.size()];

        backtracking(0, 0);
        System.out.println(result);
    }

    public static void backtracking(int start, int count) {
        if (count == M) {       // M개의 치킨집을 뽑음
            int total = 0;      // 치킨 거리

            for (int i = 0; i < house.size(); i++) {
                int temp = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (visited[j]) {       // 어떤 집과 치킨집 중 방문한 치킨집의 모든 거리를 구함
                        int dist = Math.abs(house.get(i).x - chicken.get(j).x) + Math.abs(house.get(i).y - chicken.get(j).y);

                        temp = Math.min(temp, dist);
                    }
                }
                total += temp;
            }
            result = Math.min(result, total);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            visited[i] = true;
            backtracking(i + 1, count + 1);
            visited[i] = false;
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
