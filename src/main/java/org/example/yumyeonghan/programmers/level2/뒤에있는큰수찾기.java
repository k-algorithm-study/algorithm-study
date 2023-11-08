package org.example.yumyeonghan.programmers.level2;

import java.util.ArrayDeque;
import java.util.Deque;

// https://school.programmers.co.kr/learn/courses/30/lessons/154539
public class 뒤에있는큰수찾기 {

  public int[] solution(int[] numbers) {
    Deque<Integer> stack = new ArrayDeque<>();
    int[] answer = new int[numbers.length];
    stack.push(0);
    for (int i = 1; i < numbers.length; i++) {
      while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
        answer[stack.pop()] = numbers[i];
      }
      stack.push(i);
    }
    while (!stack.isEmpty()) {
      answer[stack.pop()] = -1;
    }
    return answer;
  }

}
