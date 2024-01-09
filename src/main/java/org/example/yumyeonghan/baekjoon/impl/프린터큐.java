package org.example.yumyeonghan.baekjoon.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1966
public class 프린터큐 {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer;

    int testCase = Integer.parseInt(bufferedReader.readLine());
    for (int i = 0; i < testCase; i++) {
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      int n = Integer.parseInt(stringTokenizer.nextToken()); // 문서의 개수
      int m = Integer.parseInt(stringTokenizer.nextToken()); // 궁금한 문서의 위치

      Queue<int[]> queue = new LinkedList<>();
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      for (int location = 0; location < n; location++) {
        int priority = Integer.parseInt(stringTokenizer.nextToken());
        queue.add(new int[]{location, priority});
      }

      // start print queue
      int orderNumber = 0;
      while (true) {
        int[] currentDoc = queue.poll();
        boolean isBig = true;
        // 현재 문서보다 우선순위가 더 높은게 큐에 있으면 중단
        for (int[] q : queue) {
          if (currentDoc[1] < q[1]) {
            isBig = false;
            break;
          }
        }
        if (isBig) {
          orderNumber++;
          if (currentDoc[0] == m) {
            break;
          }
        } else {
          queue.add(currentDoc);
        }
      }
      System.out.println(orderNumber);
    }
  }

}
