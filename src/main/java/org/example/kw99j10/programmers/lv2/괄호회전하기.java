package org.example.kw99j10.programmers.lv2;

import java.util.Stack;

/**
 * 괄호 회전하기, programmers:Level 2
 */
public class 괄호회전하기 {
    public int solution(String s) {
        int answer = 0;

        int count = 0; //문자열을 회전한 횟수
        while (count != s.length()) {

            String tmp = s.substring(count) + s.substring(0, count); //한 칸씩 회전시킨 문자열

            Stack<Character> st = new Stack<>();

            boolean right = true; //올바른 괄호 문자열을 판단할 변수
            for (int i = 0; i < tmp.length(); i++) {
                char c = tmp.charAt(i);

                if (c == '(' || c == '[' || c == '{') {
                    st.push(c); //여는 괄호는 무조건 push
                } else {
                    if (st.isEmpty()) {
                        if (c == ')' || c == ']' || c == '}') {
                            right = false; //스택이 비어있을 때 닫는 괄호가 들어오면 무조건 x
                            break;
                        }
                    } else { //스택이 비어있지 않을 때 닫는 괄호가 오려면 여는 괄호가 있어야 함
                        if (c == ')') {
                            if (!st.contains('(')) {
                                right = false;
                                break;
                            } else {
                                st.pop();
                            }
                        } else if (c == '}') {
                            if (!st.contains('{')) {
                                right = false;
                                break;
                            } else {
                                st.pop();
                            }
                        } else if (c == ']') {
                            if (!st.contains('[')) {
                                right = false;
                                break;
                            } else {
                                st.pop();
                            }
                        }
                    }
                }
            }

            //여는 괄호만 있을 경우: right && !st.isEmpty()
            if (right && st.isEmpty()) {
                answer += 1;
            }

            count += 1;
        }
        return answer;
    }
}
