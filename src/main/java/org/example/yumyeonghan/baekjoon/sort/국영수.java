package org.example.yumyeonghan.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/10825
public class 국영수 {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bufferedReader.readLine());
    String[][] arr = new String[n][4];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
      arr[i][0] = st.nextToken();
      arr[i][1] = st.nextToken();
      arr[i][2] = st.nextToken();
      arr[i][3] = st.nextToken();
    }
    Arrays.sort(arr, ((o1, o2) -> {
      if (o2[1].equals(o1[1])) {
        if (o1[2].equals(o2[2])) {
          if (o1[3].equals(o2[3])) {
            return o1[0].compareTo(o2[0]);
          }
          return Integer.parseInt(o2[3]) - Integer.parseInt(o1[3]);
        }
        return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
      }
      return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
    }));
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i][0]);
    }
  }

}
