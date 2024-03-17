package org.example.kw99j10.programmers.lv2;

/**
 * 삼각 달팽이, programmers:Level 2
 */
public class 삼각달팽이 {
    public int[] solution(int n) {
        int[] answer = new int[(n * (n + 1)) / 2];

        int[][] arr = new int[n][n];

        int x = -1;
        int y = 0;
        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                if (i % 3 == 0) {
                    x += 1;
                } else if (i % 3 == 1) {
                    y += 1;
                }
                else{
                    x -= 1;
                    y -= 1;
                }
                arr[x][y] = count++;
            }
        }

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    break;
                }
                answer[idx++] = arr[i][j];
            }
        }

        return answer;
    }
}
