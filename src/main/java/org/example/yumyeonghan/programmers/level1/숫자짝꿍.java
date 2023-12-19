package org.example.yumyeonghan.programmers.level1;


// https://school.programmers.co.kr/learn/courses/30/lessons/131128
public class 숫자짝꿍 {

  public String solution(String X, String Y) {
    StringBuilder answer = new StringBuilder();
    int[] xArr = new int[10];
    int[] yArr = new int[10];
    for (String x : X.split("")) {
      xArr[Integer.parseInt(x)] += 1;
    }
    for (String y : Y.split("")) {
      yArr[Integer.parseInt(y)] += 1;
    }

    for (int i = 9; i >= 0; i--) {
      while (xArr[i] > 0 && yArr[i] > 0) {
        answer.append(i);
        xArr[i]--;
        yArr[i]--;
      }
    }
    if (answer.toString().isEmpty()) {
      return "-1";
    }
    if (answer.toString().startsWith("0")) {
      return "0";
    }
    return answer.toString();
  }

}
