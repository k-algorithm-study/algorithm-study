package org.example.hcu55.programmers.level2;

import java.util.*;

// 무인도 여행, Programmers(Level 2)
public class 무인도여행 {
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        map = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].toCharArray();
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (!visited[i][j] && map[i][j] != 'X') {
                    int day =  bfs(i, j);
                    answer.add(day);
                }
            }
        }
        if (answer.size() == 0) {
            answer.add(-1);
        }
        Collections.sort(answer);
        return answer.stream().mapToInt(Integer::intValue).toArray();   // List값을 int[] 배열로 변경
    }

    public static int bfs(int x, int y) {
        int sum = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            sum += map[nowX][nowY] - '0';
            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if (nextX >= 0 && nextX < map.length && nextY >= 0 && nextY < map[0].length) {
                    if (!visited[nextX][nextY] && map[nextX][nextY] != 'X') {
                        visited[nextX][nextY] = true;
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }
        return sum;
    }
}
