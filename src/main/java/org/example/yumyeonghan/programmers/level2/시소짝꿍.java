package org.example.yumyeonghan.programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/152996
public class 시소짝꿍 {

  public long solution(int[] weights) {
    long answer = 0;
    Arrays.sort(weights);
    Map<Double, Integer> map = new HashMap<>();
    for (int weight : weights) {
      // 맵에서 자신보다 작은 수의 짝 찾기
      double a = (weight * 1.0);
      double b = (weight * 1.0) / 2.0;
      double c = (weight * 2.0) / 3.0;
      double d = (weight * 3.0) / 4.0;
      if (map.containsKey(a)) {
        answer += map.get(a);
      }
      if (map.containsKey(b)) {
        answer += map.get(b);
      }
      if (map.containsKey(c)) {
        answer += map.get(c);
      }
      if (map.containsKey(d)) {
        answer += map.get(d);
      }
      // 자신을 맵에 저장 (짝이 될 수 있는 weight는 중복을 허용해야 하기 때문에 이전의 값 + 1 해야함)
      // ex) 200의 짝은 100이 될 수 있는데, 100이 2개라면 짝은 2가 됨
      map.put(weight * 1.0, map.getOrDefault(weight * 1.0, 0) + 1);
    }
    return answer;
  }

}
