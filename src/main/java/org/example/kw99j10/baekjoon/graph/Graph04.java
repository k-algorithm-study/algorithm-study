package org.example.kw99j10.baekjoon.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 숨바꼭질 - Silver I
 * 찾을 수 있는 가장 빠를 시간 -> 최소 시간 -> bfs
 */
public class Graph04 {
    static int [] graph; //위치에 따른 시간을 나타내는 그래프
    static int N; //수빈이가 있는 점
    static int K; //동생이 있는 점

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); //수빈이가 있는 점
        K = sc.nextInt(); //동생이 있는 점

        graph = new int[100001]; //그래프 초기화

        //위치가 같지 않은 경우만 bfs 실행
        if (N != K){
            bfs(N);
        }
        else{
            System.out.println(0);
        }
    }

    static void bfs(int n) {
        boolean[] visit = new boolean[100001]; //방문을 확인할 배열
        Queue<Integer> queue = new LinkedList<>(); //현재 좌표를 담을 큐
        queue.offer(n);

        while (!queue.isEmpty()) {
            int current = queue.poll(); //현재 위치
            int next = 0; //다음 위치

            //움직일 수 있는 경우의 수
            for (int i = 0; i < 3; i++) {

                //cf)제출 시 강화된 switch문 사용 x
                switch (i) {
                    case 0 -> next = current - 1;
                    case 1 -> next = current + 1;
                    case 2 -> next = current * 2;
                }

                //다음 위치가 동생의 위치와 같다면 반복문 종료
                //이때, 마지막 이동까지 시간에 더함
                if (next == K) {
                    System.out.println(graph[current] + 1);
                    return;
                }

                //좌표 내에 있고 방문하지 않았다면 큐에 다음 위치를 넣음
                //시간 +1 갱신
                if (next >= 0 && next < graph.length && !visit[next]) {
                    queue.add(next);
                    visit[next] = true;
                    graph[next] = graph[current] + 1;
                }
            }
        }
    }
}
