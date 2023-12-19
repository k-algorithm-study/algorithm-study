package org.example.kw99j10.programmers.lv1;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class 숫자짝꿍 {
    public String solution(String X, String Y) {

        //공통된 숫자들로 가장 큰 수를 만들기 위한 우선순위 큐
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        var h = new HashMap<Character, Integer>();

        //X에서 나온 문자와 그 빈도를 Map에 저장
        for (int i = 0; i < X.length(); i++) {
            h.put(X.charAt(i), h.getOrDefault(X.charAt(i), 0) + 1);
        }

        //Y문자열의 길이 동안 공통으로 사용된 문자를 큐에 저장
        for (int i = 0; i < Y.length(); i++) {

            char c = Y.charAt(i);

            if (h.size() == 0) {
                break; //map의 크기가 0이라면 반복문 종료
            }

            //공통된 문자열을 큐에 저장 & map에서 제거
            if (h.containsKey(c) && h.get(c) > 0) {
                queue.add(Integer.parseInt(String.valueOf(c)));
                h.put(c, h.getOrDefault(c, 0) - 1);
            }
        }

        StringBuilder answer = new StringBuilder();

        //큐의 사이즈가 0: 공통 숫자 없음
        if (queue.size() == 0) {
            return "-1";
        }

        while (!queue.isEmpty()) {
            answer.append(queue.poll());
        }

        //공통된 숫자가 0으로만 이루어 졌다면 "0"으로 치환
        if (answer.toString().startsWith("0")) {
            answer = new StringBuilder("0");
        }

        return answer.toString();
    }
}
