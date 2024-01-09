package org.example.kw99j10.programmers.lv2;

import java.util.LinkedList;

/**
 * 전력망을 둘로 나누기, programmers:Level 2
 *
 **/
public class 전력망을둘로나누기 {
    public int solution(int n, int[][] wires) {
        int answer = 101;

        int[][] tmp = new int[n + 1][n + 1]; //전력망의 개수

        for (int[] wire : wires) {
            tmp[wire[0]][wire[1]] = 1;
            tmp[wire[1]][wire[0]] = 1; //송전탑이 연결되어 있음을 의미
        }

        //wire를 하나씩 끊어서 두 전력망의 송전탑 개수 차이를 구함
        for (int[] wire : wires) {

            int a = wire[0];
            int b = wire[1];

            tmp[a][b] = 0;
            tmp[b][a] = 0;

            int count = bfs(n, tmp, a);

            tmp[a][b] = 1;
            tmp[b][a] = 1; //원상 복구 해놈

            //절댓값 차이를 구함
            answer = Math.min(answer, Math.abs(2 * count - n));
        }
        return answer;
    }
    static int bfs(int n, int[][] tmp, int a) {
        boolean[] visit = new boolean[n + 1];
        int count = 1;

        var queue = new LinkedList<Integer>();
        queue.offer(a);

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            visit[current] = true;

            for (int j = 1; j <= n; j++) {

                if (visit[j]) {
                    continue;
                }

                if (tmp[current][j] == 1) {
                    queue.offer(j);
                    count += 1;
                }
            }
        }
        return count;
    }
}
