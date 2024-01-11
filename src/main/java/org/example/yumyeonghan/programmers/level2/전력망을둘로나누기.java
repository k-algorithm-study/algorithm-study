package org.example.yumyeonghan.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/86971
public class 전력망을둘로나누기 {

  private static int[][] graph;

  public int solution(int n, int[][] wires) {
    int answer = (int) 1e9;
    // init graph
    graph = new int[n + 1][n + 1];
    for (int i = 0; i < wires.length; i++) {
      int x = wires[i][0];
      int y = wires[i][1];
      graph[x][y] = 1;
      graph[y][x] = 1;
    }

    // full search (전선 하나씩 끊어가면서)
    for (int i = 0; i < wires.length; i++) {
      int x = wires[i][0];
      int y = wires[i][1];
      graph[x][y] = 0;
      graph[y][x] = 0;
      answer = Math.min(answer, bfs(n, 1));
      graph[x][y] = 1;
      graph[y][x] = 1;
    }
    return answer;
  }

  private int bfs(int n, int start) {
    int count = 1;
    Queue<Integer> queue = new LinkedList<>();
    boolean[] isVisited = new boolean[n + 1];
    queue.add(start);
    isVisited[start] = true;
    while (!queue.isEmpty()) {
      Integer current = queue.poll();
      for (int i = 1; i <= n; i++) {
        if (graph[current][i] == 1 && !isVisited[i]) {
          queue.add(i);
          isVisited[i] = true;
          count++;
        }
      }
    }
    // 두 전력망의 송전탑 개수의 차이 = (전체 - 한쪽의 송전탑 개수) - 한쪽의 송전탑 개수
    return Math.abs(n - count - count);
  }

}
