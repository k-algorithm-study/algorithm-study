package org.example.hcu55.programmers.level2;

import java.util.Collections;
import java.util.PriorityQueue;

// 혼자 놀기의 달인, Programmers(Level 2)
public class 혼자놀기의달인 {
    static PriorityQueue<Integer> queue;

    public int solution(int[] cards) {
        int answer = 0;

        boolean[] visited = new boolean[cards.length];
        queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < cards.length; i++) {        // 열지 않은 상자면 dfs 탐색
            if(!visited[i]) {
                dfs(cards, i, visited, 0);
            }
        }

        if(queue.size() != 1) {
            answer = queue.poll() * queue.poll();
        }
        return answer;
    }

    static void dfs(int[] cards, int num, boolean[] visited, int cnt) {
        if(visited[num]) {      // 이미 방문함
            queue.add(cnt);
            return;
        }
        visited[num] = true;
        dfs(cards, cards[num] - 1, visited, cnt + 1);
    }
}
