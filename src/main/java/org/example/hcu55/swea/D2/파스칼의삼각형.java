package org.example.hcu55.swea.D2;

import java.io.*;

public class 파스칼의삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());

            int[][] triangle = new int[N][N];           // 삼각형 저장할 2차원 배열

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (j == 0) {                       // 왼쪽 끝은 무조건 1
                        triangle[i][j] = 1;
                    } else if (j == N - 1) {            // 오른쪽 끝도 1
                        triangle[i][j] = 1;
                    } else if (i > 0){                  // i>0 조건이 있어야 에러가 안뜸
                        triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
                    }
                }
            }

            // 출력
            System.out.println("#" + testCase);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= i; j++) {
                    System.out.print(triangle[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
