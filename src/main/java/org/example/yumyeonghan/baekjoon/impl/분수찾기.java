package org.example.yumyeonghan.baekjoon.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1193
public class 분수찾기 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int x = Integer.parseInt(br.readLine());
    br.close();

    int squareCount = 1; // 현재 대각선의 칸 수
    int squareSum = 0; // 이전 대각선의 칸 누적

    // 첫번째 대각선 부터 순회
    while (true) {
      // 현재 대각선에 X번째의 분수가 있을 때
      if (x <= squareSum + squareCount) {
        // 대각선의 개수가 홀수일때 위쪽으로 순회, 분자 감소 분모 증가
        if (squareCount % 2 == 1) {
          int denominator = squareCount - (x - squareSum - 1);
          int molecule = x - squareSum;
          System.out.println((denominator + "/" + molecule));
          break;
        } else { // 대각선의 개수가 짝수일때 아래쪽으로 순회, 분자 증가 분모 감소
          int denominator = x - squareSum;
          int molecule = squareCount - (x - squareSum - 1);
          System.out.println(denominator + "/" + molecule);
          break;
        }
      } else { // 현재 대각선에 X번째의 분수가 없을 때
        squareSum += squareCount;
        squareCount++;
      }
    }
  }

}
