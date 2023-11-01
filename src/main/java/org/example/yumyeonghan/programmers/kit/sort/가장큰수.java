package org.example.yumyeonghan.programmers.kit.sort;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/42746
public class 가장큰수 {

  public static void main(String[] args) {
    System.out.println(new 가장큰수().solution(new int[]{6, 10, 2}));
  }

  public String solution(int[] numbers) {
    String answer = "";
    String[] str = new String[numbers.length];
    for (int i = 0; i < numbers.length; i++) {
      str[i] = String.valueOf(numbers[i]);
    }

    // 두 수를 앞 뒤로 합친 수 중 큰 값을 앞으로 정렬 (내림 차순)
    Arrays.sort(str, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

    // int[] numbers = {0}
    if (str[0].equals("0")) {
      return "0";
    }

    for (String num : str) {
      answer += num;
    }
    return answer;
  }

}
