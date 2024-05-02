package org.example.hcu55.programmers.level2;

// 삼각 달팽이, Programmers(Level 2)
public class 삼각달팽이 {
    public int[] solution(int n) {
        int[] answer = new int[n * (n + 1) / 2];    // 삼각형의 크기 ( 1 ~ n 까지 합)
        int[][] arr = new int[n][n];

        int x = -1;     // x 좌표
        int y = 0;      // y 좌표
        int num = 1;    // 달팽이 채우기 값

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {           // 대각선 아래
                    x++;
                } else if (i % 3 == 1) {    // 가로
                    y++;
                } else if (i % 3 == 2) {    // 대각선 위
                    x--;
                    y--;
                }
                arr[x][y] = num++;
            }
        }

        int index = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    break;
                }
                answer[index++] = arr[i][j];
            }
        }
        return answer;
    }
}
