package org.example.hcu55.swea.D3;

import java.io.*;

public class 농작물수확하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            int[][] farm = new int[N][N];

            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    farm[i][j] = str.charAt(j) - '0';          // 문자열 int 형으로 변환하여 저장
                }
            }

            int sum = 0;        // 농작물 가치 합 변수

            // 세로 중앙 포함 기준 왼쪽 위 (가로 중앙까지 포함)
            for (int i = 0; i <= N / 2; i++) {
                for (int j = N / 2; j >= N / 2 - i; j--) {
                    sum += farm[i][j];
                }
            }

            // 세로 중앙 제외 기준 오른쪽 (가로 중앙까지 포함)
            for (int i = 0; i <= N / 2; i++) {
                for (int j = N / 2 + 1; j <= N / 2 + i;  j++) {
                    sum += farm[i][j];
                }
            }

            // 중간 가로 제외 아래쪽 모두
            for (int i = N / 2 + 1; i < N; i++) {
                for (int j = i - N / 2; j < N / 2 - i + N; j++) {
                    sum += farm[i][j];
                }
            }

            System.out.println("#" + testCase + " " + sum);
        }
    }
}
