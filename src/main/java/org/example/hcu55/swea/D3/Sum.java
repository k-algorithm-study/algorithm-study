package org.example.hcu55.swea.D3;

import java.util.*;
import java.io.*;

public class Sum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int testCase = 1; testCase <= 10; testCase++) {
            int T = Integer.parseInt(br.readLine());
            int[][] arr = new int[100][100];

            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());       // 2차원 배열 값 입력받기
                }
            }

            int max = 0;        // 최대깂 변수

            // 행, 열의 합 동시에
            for (int i = 0; i < 100; i++) {
                int row = 0;
                int col = 0;
                for (int j = 0; j < 100; j++) {
                    row += arr[i][j];
                    col += arr[j][i];

                    if (row > max) {
                        max = row;
                    }
                    if (col > max) {
                        max = col;
                    }
                }
            }

            // 대각선 합
            int diagonal1 = 0;      // 우 하향 합 변수
            int diagonal2 = 0;      // 좌 하향 합 변수

            for (int i = 0; i < 100; i++) {
                diagonal1 += arr[i][i];         // 우 하향 합
                diagonal2 += arr[i][99 - i];    // 좌 하향 합
            }

            if (diagonal1 > max) {
                max = diagonal1;
            }
            if (diagonal2 > max) {
                max = diagonal2;
            }

            System.out.println("#" + T + " " + max);
        }
    }
}
