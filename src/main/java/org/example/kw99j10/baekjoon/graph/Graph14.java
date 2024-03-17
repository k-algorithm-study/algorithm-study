package org.example.kw99j10.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 *  스타트링크 - Silver I
 */
public class Graph14 {
    static int f, s, g, u, d;
    static int[] map;
    static int[] dx = {1, -1};
    static int answer = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[f + 1];
        if (s == g) {
            System.out.println(0);
            return;
        }
        bfs(s);
        System.out.println(answer == -1 ? "use the stairs" : answer);
    }
    static void bfs(int x) {
        ArrayDeque<int []> queue = new ArrayDeque<>();
        boolean[] visit = new boolean[f + 1];
        queue.add(new int[]{x, 0});
        visit[x] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int current = cur[0];
            int count = cur[1];

            if (current == g) {
                answer = count;
                return;
            }

            int next;
            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    next = current + dx[i] * u;
                }
                else{
                    next = current + dx[i] * d;
                }

                if (next <= 0 || next > f || visit[next]) {
                    continue;
                }

                visit[next] = true;
                queue.add(new int[]{next, count + 1});
            }
        }
    }
}
