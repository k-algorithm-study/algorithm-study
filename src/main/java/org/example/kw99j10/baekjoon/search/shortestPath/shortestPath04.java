package org.example.kw99j10.baekjoon.search.shortestPath;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 최소비용 구하기 - Gold V
 * 다익스트라: 시작점에서 종료점까지 최단거리를 갱신
 */
public class shortestPath04 {
    static class Node {
        int v; //목적지 노드
        int cost; //목적지 노드 까지 걸리는 비용(가중치)
        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    static ArrayList<Node>[] lists; //노드 정보를 담을 리스트
    static boolean[] visit; //방문 확인 배열
    static int[] distance; //노드 간 최단 거리를 담는 배열
    static PriorityQueue<Node> queue; //최단 거리를 구하기 위함 & 중복 방지
    static int start;
    static int end;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //도시의 개수
        int m = sc.nextInt(); //버스의 개수

        //각 배열 선언 및 초기화
        lists = new ArrayList[n + 1];
        visit = new boolean[n + 1];
        distance = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            int st = sc.nextInt(); //출발 도시
            int fin = sc.nextInt(); //도착 도시
            int cost = sc.nextInt(); //버스 비용

            lists[st].add(new Node(fin, cost));
        }

        //구하고자 하는 구간 출발점의 도시번호와 도착점의 도시번호
        start = sc.nextInt();
        end = sc.nextInt();

        dijkstra(start);
    }
    private static void dijkstra(int start) {

        queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));

        //시작점 start 초기화
        queue.add(new Node(start, 0));
        visit[start] = true;
        distance[start] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node.v+" "+node.cost);

            if (node.v == end) { //start -> end 까지의 최단 거리를 찾음
                System.out.println(distance[end]);
                break;
            }
            /*if (node.cost >= distance[end]) {
                System.out.println(distance[end]);
                break;
            }*/

            if (!visit[node.v]) {
                visit[node.v] = true; //방문한 노드가 아니라면 방문
            }
            for (Node list : lists[node.v]) {
                if (!visit[list.v] && distance[list.v] > node.cost + list.cost) {
                    distance[list.v] = node.cost + list.cost;
                    queue.add(new Node(list.v, distance[list.v]));
                }
            }
        }
    }
}
