package org.example.kw99j10.baekjoon.search.dfsBfs;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * DFS와 BFS - Silver II
 */
public class DfsBfs01 {

    static boolean[] dfs_visit; //dfs 방문 배열
    static boolean[] bfs_visit; //bfs 방문 배열
    static int [][]arr; //정점 사이의 간선을 담을 배열

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //정점의 개수
        int m = sc.nextInt(); //간선의 개수
        int v = sc.nextInt(); //탐색을 시작할 정점의 번호

        arr = new int[n + 1][n + 1]; //(정점의 개수 + 1)

        //간선이 연결하는 두 정점의 번호
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
            arr[b][a] = 1; //연결 확인
        }
        dfs_visit = new boolean[n + 1];
        dfs(v);
        System.out.println();
        bfs_visit = new boolean[n + 1]; //방문을 확인할 배열
        bfs(v);
    }
    static void dfs(int v){
        dfs_visit[v]=true;
        System.out.print(v+" ");
        for (int j=1;j<arr.length;j++) {
            if (arr[v][j] == 1 && !dfs_visit[j]) {
                dfs(j);
            }
        }
    }
    static void bfs(int v){
        var q = new LinkedList<Integer>(); //bfs를 위한 큐
        q.offer(v); //v부터 탐색을 시작하므로 v를 큐에 넣음
        bfs_visit[v] = true;
        System.out.print(v+" ");
        while (!q.isEmpty()) {
            int point = q.poll();
            for (int j = 1; j < bfs_visit.length; j++) {
                if (arr[point][j] == 1 && !bfs_visit[j]) {
                    q.offer(j);
                    System.out.print(j+" ");
                    bfs_visit[j] = true;
                }
            }
        }
    }
}
