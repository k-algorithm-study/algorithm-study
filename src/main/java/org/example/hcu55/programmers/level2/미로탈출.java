package org.example.hcu55.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

// 미로 탈출, Programmers(Level 2)
public class 미로탈출 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] targetLoc = new int[2];

    public int solution(String[] maps) {
        int answer = 0;

        String[][] map = new String[maps.length][maps[0].length()];
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        int[] start = new int[2];

        // 맵을 저장하고 시작 위치 파악
        for (int i = 0; i < maps.length; i++) {
            String[] temp = maps[i].split("");
            map[i] = temp;
            for (int j = 0; j < temp.length; j++) {
                if (temp[j].equals("S")) {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        // 레버까지 BFS 탐색
        int foundLever = bfs(map, visited, start, "L");
        if (foundLever == -1) {
            return -1;
        }

        // 탈출지점까지 BFS 탐색
        visited = new boolean[maps.length][maps[0].length()];
        int foundExit = bfs(map, visited, targetLoc, "E");
        if (foundExit == -1) {
            return -1;
        }

        answer = foundLever + foundExit;
        return answer;
    }

    public int bfs(String[][] map, boolean[][] visited, int[] start, String target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;     //출발지

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            int second = now[2];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX >= 0 && nextX < map.length && nextY >= 0 && nextY < map[0].length) {
                    if (map[nextX][nextY].equals(target)) {
                        targetLoc[0] = nextX;
                        targetLoc[1] = nextY;
                        return second + 1;
                    }
                    if (!map[nextX][nextY].equals("X") && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY, second + 1});
                    }
                }
            }
        }
        return -1;
    }
}
