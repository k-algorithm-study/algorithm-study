package org.example.kw99j10.programmers.lv2;
/**
 * 행렬 테두리 회전하기, programmers:Level 2
 */
public class 행렬테두리회전하기 {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        int[][] arr = new int[rows + 1][columns + 1];
        int count = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                arr[i][j] = count++;
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int start_x = queries[i][0];
            int start_y = queries[i][1];

            int end_x = queries[i][2];
            int end_y = queries[i][3];

            int min = 10001;
            int tmp = arr[start_x][start_y]; //시작점 (start_x,start_y)

            // 오른쪽 방향 이동
            for (int j = start_y; j <= end_y; j++) {
                int t = arr[start_x][j];
                arr[start_x][j] = tmp;
                tmp = t;
                min = Math.min(min, tmp);
            }

            //아래 방향 이동
            for (int j = start_x + 1; j <= end_x; j++) {
                int t = arr[j][end_y];
                arr[j][end_y] = tmp;
                tmp = t;
                min = Math.min(min, tmp);
            }

            //왼쪽 방향 이동
            for (int j = end_y - 1; j >= start_y; j--) {
                int t = arr[end_x][j];
                arr[end_x][j] = tmp;
                tmp = t;
                min = Math.min(min, tmp);
            }

            //위 방향 이동
            for (int j = end_x - 1; j >= start_x; j--) {
                int t = arr[j][start_y];
                arr[j][start_y] = tmp;
                tmp = t;
                min = Math.min(min, tmp);
            }
            answer[i] = min;
        }
        return answer;
    }
}
