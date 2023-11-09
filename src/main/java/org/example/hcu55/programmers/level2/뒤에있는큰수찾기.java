package org.example.hcu55.programmers.level2;

import java.util.Stack;

// 뒤에 있는 큰 수 찾기, Programmers(Level 2)
public class 뒤에있는큰수찾기 {
    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();   // numbers를 담을 스택
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
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
