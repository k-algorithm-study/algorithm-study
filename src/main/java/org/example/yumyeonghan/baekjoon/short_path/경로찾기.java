package org.example.yumyeonghan.baekjoon.short_path;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11403
public class 경로찾기 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int result[][] = new int[n][n];

    // 입력 값은 항상 지나기 때문에 바로 정답 처리
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        result[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // k를 지남
    for (int k = 0; k < n; k++) {
      // i에서 시작
      for (int i = 0; i < n; i++) {
        // j에 도작
        for (int j = 0; j < n; j++) {
          if (result[i][k] == 1 && result[k][j] == 1) {
            result[i][j] = 1; // i 에서 k 를 지나 j 로 갈 수 있으므로 정답 처리
          }
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        bw.write(result[i][j] + " ");
      }
      bw.write("\n");
    }
    bw.flush();
  }

}
