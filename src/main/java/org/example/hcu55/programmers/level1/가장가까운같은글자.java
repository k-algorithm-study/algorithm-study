package org.example.hcu55.programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 가장 가까운 같은 글자, Programmers(Level 1)
public class 가장가까운같은글자 {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Arrays.fill(answer, -1);    // 배열 -1 세팅
        Map<Character, Integer> map = new HashMap<>();  // 맵에 문자와 위치 저장할거임

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {     // 맵에 문자가 이미 저장되어 있다면
                answer[i] = i - map.get(s.charAt(i));   // 거리 구해서 저장
                map.put(s.charAt(i), i);            // 최근 위치로 변환
            } else {
                map.put(s.charAt(i), i);    // map에 없다면 문자와 위치 넣기
            }
        }
        return answer;
    }
}
