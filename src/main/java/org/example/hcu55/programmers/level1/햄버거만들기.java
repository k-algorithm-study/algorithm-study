package org.example.hcu55.programmers.level1;

import java.util.Stack;

// 햄버거 만들기, Programmers(Level 1)
public class 햄버거만들기 {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();   // 스택 구현

        for (int i : ingredient) {
            stack.push(i);
            if (stack.size() >= 4) {        // 길이가 4이상 부터 찾기
                if (stack.peek() == 1       // 1231 순서로 들어있으면 뽑기
                        && stack.get(stack.size() - 2) == 3
                        && stack.get(stack.size() - 3) == 2
                        && stack.get(stack.size() - 4) == 1) {
                    answer++;
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                }
            }
        }
        return answer;
    }
}
