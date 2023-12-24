package org.example.kw99j10.baekjoon.search.dfsBfs;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 트리의 부모 찾기 - Silver II
 */
public class DfsBfs08 {
    static ArrayList<Integer>[] arr; //트리의 정보를 담을 인접 리스트
    static boolean[] visit; //방문을 확인할 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        visit = new boolean[n + 1];
        arr = new ArrayList[n + 1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>(); //리스트 초기화
        }

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a].add(b);
            arr[b].add(a);
        }

        //부모 노드를 담을 배열
        int[] p = new int[n + 1];

        //bfs를 위한 큐
        var queue = new LinkedList<Integer>();
        queue.add(1);
        visit[1] = true;

        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            for (Integer next : arr[current]) {
                if (!visit[next]) {
                    visit[next] = true;
                    queue.add(next);
                    p[next] = current;
                }
            }
        }
        for (int i = 2; i < p.length; i++) {
            System.out.println(p[i]);
        }
    }
}
