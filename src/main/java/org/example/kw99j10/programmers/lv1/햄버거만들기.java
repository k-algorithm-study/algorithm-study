package org.example.kw99j10.programmers.lv1;

import java.util.Stack;

/**
 * 햄버거 만들기, programmers:Level 1
 */
public class 햄버거만들기 {
    public int solution(int[] ingredient) {
        int answer = 0;

        //배열의 원소: 1: 빵, 2: 야채, 3: 고기

        var s = new Stack<Integer>(); //재료를 담을 스택

        for (int j : ingredient) {

            s.push(j);

            if (s.size() >= 4) {
                if (s.peek() == 1 && s.get(s.size() - 2) == 3 &&
                        s.get(s.size() - 3) == 2 && s.get(s.size() - 4) == 1) {

                    answer += 1;
                    s.pop();
                    s.pop();
                    s.pop();
                    s.pop();
                }
            }
        }
        return answer;
    }
}
