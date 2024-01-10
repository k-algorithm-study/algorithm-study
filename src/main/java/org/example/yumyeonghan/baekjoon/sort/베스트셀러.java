package org.example.yumyeonghan.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// https://www.acmicpc.net/problem/1302
public class 베스트셀러 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Map<String, Integer> map = new TreeMap<>();
    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      map.put(line, map.getOrDefault(line, 0) + 1);
    }
    List<Integer> soldNumber = new ArrayList<>(map.values());
    soldNumber.sort((o1, o2) -> o2 - o1);
    int max = soldNumber.get(0);
    for (String s : map.keySet()) {
      if (map.get(s) == max) {
        System.out.println(s);
        break;
      }
    }
  }

}
