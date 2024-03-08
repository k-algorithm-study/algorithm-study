package org.example.kw99j10.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 이분 그래프 - Gold IV
 */
public class Graph11 {
    static int V;
    static ArrayList<Integer>[] lists;
    static int[] group; //분할한 각 집합
    static String answer; //yes or no
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int testCase = 0; testCase < k; testCase++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            lists = new ArrayList[V + 1];
            group = new int[V + 1];
            for (int i = 1; i <= V; i++) {
                lists[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                //인접한 두 정점 번호
                lists[v].add(e);
                lists[e].add(v);
            }

            answer = "YES";
            for (int i = 1; i <= V; i++) {
                if (group[i] == 0) {
                    bfs(i); //아직 그룹이 없다면 bfs 수행
                }
            }
            for (int i = 1; i <= V; i++) {
                System.out.print(group[i] + " ");
            }
            System.out.println();
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(int i) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(i);
        group[i] = 1; //하나의 그룹

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            for (Integer next : lists[current]) {
                if (group[current] == group[next]) {
                    answer = "NO"; //정점이 인접함
                    break;
                }
                if (group[next] == 0) {
                    group[next] = group[current] * -1; //숫자 상관 x
                    queue.add(next); //그룹이 없으면 정점을 초기화
                }
            }
        }

    }
}
