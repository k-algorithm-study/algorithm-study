package org.example.kw99j10.programmers.lv2;

import java.util.Stack;

public class 택배상자 {
    public int solution(int[] order) {
        int answer = 0; //실을 수 있는 상자의 개수

        int count = 0; //현재 상자 인덱스

        var s = new Stack<Integer>(); //보조 컨테이너

        //택배상자는 1번부터 n번까지 컨테이너에 놓임
        for (int i = 1; i <= order.length; i++) {

            while (!s.isEmpty() && s.peek() == order[count]) {
                s.pop();
                count += 1;
                answer += 1;
            }

            if (order[count] == i) {
                count += 1;
                answer += 1;
            }
            else{
                s.push(i);
            }
        }

        while (!s.isEmpty() && s.peek() == order[count]) {
            s.pop();
            count += 1;
            answer += 1;
        }

        return answer;
    }
}
