package org.example.kw99j10.programmers.lv2;

import java.util.Arrays;
import java.util.Stack;

/**
 * 뒤에 있는 큰 수 찾기, programmers:Level 2
 */
public class 뒷큰수찾기 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length]; //뒷 큰수를 담을 배열
        Arrays.fill(answer, -1); // -1로 배열 초기화

        var s = new Stack<Integer>(); //수를 비교할 stack

        for (int i = 0; i < numbers.length; i++) {

            //뒤에 있는 숫자 중 가장 가까운 큰 수를 담음
            //s.peek(): 이전 인덱스, i: 현재 인덱스 의 값 비교
            while (!s.isEmpty() && numbers[s.peek()] < numbers[i]) {
                answer[s.pop()] = numbers[i];
            }
            s.push(i); //배열의 인덱스를 푸쉬
        }
        return answer;
    }
}
