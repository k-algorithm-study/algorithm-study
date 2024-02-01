package org.example.hcu55.programmers.level2;

// 행렬 테두리 회전하기, Programmers(Level 2)
public class 행렬테두리회전하기 {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] area = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                area[i][j] = i * columns + j + 1;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int[] minPos = {queries[i][0] - 1, queries[i][1] - 1};
            int[] maxPos = {queries[i][2] - 1, queries[i][3] - 1};

            int start = area[minPos[0]][minPos[1]];

            int min = Integer.MAX_VALUE;

            for (int j = minPos[0]; j < maxPos[0]; j++) {          // 좌측 라인 회전
                min = Math.min(min, area[j][minPos[1]]);

                area[j][minPos[1]] = area[j + 1][minPos[1]];
            }

            for (int j = minPos[1]; j < maxPos[1]; j++) {         // 하단 라인 회전
                min = Math.min(min, area[maxPos[0]][j]);

                area[maxPos[0]][j] = area[maxPos[0]][j + 1];
            }

            for (int j = maxPos[0]; j > minPos[0]; j--) {         // 우측 라인 회전
                min = Math.min(min, area[j][maxPos[1]]);

                area[j][maxPos[1]] = area[j - 1][maxPos[1]];
            }

            for (int j = maxPos[1]; j > minPos[1]; j--) {         // 윗 라인 회전
                min = Math.min(min, area[minPos[0]][j]);

                area[minPos[0]][j] = area[minPos[0]][j - 1];
            }

            area[minPos[0]][minPos[1] + 1] = start;

            answer[i] = min;
        }
        return answer;
    }
}