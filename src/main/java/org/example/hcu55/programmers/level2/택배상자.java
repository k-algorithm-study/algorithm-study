package org.example.hcu55.programmers.level2;

import java.util.Stack;

// 택배상자, Programmers(Level 2)
public class 택배상자 {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        int index = 0;      // order 인덱스
        for (int i = 0; i < order.length; i++) {
            if (order[index] != i + 1) {        // 순서가 같지 않으면
                stack.push(i + 1);         // stack에 넣기
            } else {
                index++;
                answer++;
            }
            while (!stack.isEmpty() && order[index] == stack.peek()) {      // stack의 첫번째와 order의 순서 값이 일치할 때
                stack.pop();
                index++;
                answer++;
            }
        }
        return answer;
    }
}
