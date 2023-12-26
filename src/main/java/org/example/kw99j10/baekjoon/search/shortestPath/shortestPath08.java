package org.example.kw99j10.baekjoon.search.shortestPath;

import java.util.*;

/**
 * 특정 거리의 도시 찾기 - Silver II
 */
public class shortestPath08 {
    static int n, m, k, x;
    static ArrayList<Integer>[] lists; //도시의 정보를 담을 리스트
    static int[] distance; //도시 간 최단 거리를 담는 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); //도시의 개수
        m = sc.nextInt(); //도로의 개수
        k = sc.nextInt(); //거리 정보
        x = sc.nextInt(); //출발 도시

        //리스트 및 배열 초기화
        lists = new ArrayList[n + 1];
        distance = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            lists[a].add(b); //단방향 도로
        }
        bfs(x); //출발 도시의 번호

        var city = new ArrayList<Integer>(); //k인 도시를 모두 담는 리스트

        for (int i = 1; i <= n; i++) {
            if (distance[i] == k) {
                city.add(i);
            }
        }
        if (city.size() == 0) {
            System.out.println(-1); //k인 도시가 존재하지 않음
        } else {
            Collections.sort(city);
            for (Integer integer : city) {
                System.out.println(integer);
            }
        }
    }
    static void bfs(int start) {

        Queue<Integer> queue = new LinkedList<>();

        //시작점 start 초기화
        queue.add(start);
        distance[start] = 0;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            //해당 노드와 연결된 도시의 거리 초기화
            for (int i = 0; i <lists[poll].size();i++) {
                Integer next = lists[poll].get(i);
                if (distance[next] == Integer.MAX_VALUE) {
                    distance[next] = distance[poll] + 1;
                    queue.add(next);
                }
            }
        }
    }
}
