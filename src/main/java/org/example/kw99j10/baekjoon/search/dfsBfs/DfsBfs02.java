package org.example.kw99j10.baekjoon.search.dfsBfs;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 바이러스 - Silver III
 */
public class DfsBfs02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int computer = sc.nextInt(); //컴퓨터 수
        int twins = sc.nextInt(); //연결된 컴퓨터 쌍의 수

        int[][] virus = new int[computer + 1][computer + 1]; //연결됨을 표현할 배열

        for (int i = 0; i < twins; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            virus[a][b] = 1;
            virus[b][a] = 1;
        }

        int count = 0; //웜 바이러스에 걸리는 컴퓨터의 수

        count = bfs(computer, virus, count);
        System.out.println(count);
    }

    private static int bfs(int computer, int[][] virus, int count) {
        boolean[] b = new boolean[computer + 1]; //방문을 확인할 배열

        var q = new LinkedList<Integer>(); //bfs를 위한 큐
        q.add(1); //1번 컴퓨터부터 웜 바이러스 진행
        b[1] = true;

        while (!q.isEmpty()) {
            int point = q.poll();

            for (int j = 1; j < b.length; j++) {
                if (virus[point][j] == 1 && !b[j]) {
                    b[j] = true;
                    q.add(j);
                    count += 1;
                }
            }
        }
        return count;
    }
}
