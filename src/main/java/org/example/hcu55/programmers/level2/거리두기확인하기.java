package org.example.hcu55.programmers.level2;

// 거리두기 확인하기, Programmers(Level 2)
public class 거리두기확인하기 {
    static char[][] matrix;
    static boolean[][] visited;
    static boolean isAvailable;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < 5; i++) {
            isAvailable = false;
            matrix = new char[5][5];

            for (int j = 0; j < 5; j++) {       // matrix에 값 추가
                matrix[j] = places[i][j].toCharArray();
            }

            for (int r = 0; r < 5; r++) {       // matrix에 사람이 있는 곳들을 검사
                for (int c = 0; c < 5; c++) {
                    if (matrix[r][c] == 'P') {
                        visited = new boolean[5][5];
                        dfs(0, r, c);
                        if (isAvailable) {
                            break;
                        }
                    }
                }
                if (isAvailable) {
                    break;
                }
            }
            if (isAvailable) {
                answer[i] = 0;
            } else {
                answer[i] = 1;
            }
        }

        return answer;
    }

    static void dfs(int currentDepth, int r, int c) {
        if (currentDepth >= 2) return;
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nowX = r + dx[i];
            int nowY = c + dy[i];

            if (nowX < 0 || nowX >= 5 || nowY < 0 || nowY >= 5 || visited[nowX][nowY]) {
                continue;
            }

            if (matrix[nowX][nowY] == 'O') {            // 테이블이 있을 때
                dfs(currentDepth + 1, nowX, nowY);
            } else if (matrix[nowX][nowY] == 'P') {
                isAvailable = true;
                return;
            } else if (matrix[nowX][nowY] == 'X') {     // 벽이 있는 때
                continue;
            }
        }
    }
}
