package org.example.kw99j10.programmers.lv1;

import java.util.HashMap;

/**
 * 대충 만든 자판, programmers:Level 1
 */
public class 대충만든자판 {
    public int[] solution(String[] keymap, String[] targets) {

        //answer 배열에는 target 문자의 최소 키 입력 수를 저장
        int[] answer = new int[targets.length];

        // 문자의 최소 키 입력 수를 저장 -> keymap에 들어온 배열을 최소 값으로 저장
        var key = new HashMap<Character, Integer>();
        for (String s : keymap) {
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                //기존에 문자열이 있다면 현재 저장할 인덱스와 기존 인덱스의 최소값을 저장
                if (key.containsKey(c)) {
                    int min = Math.min(j + 1, key.getOrDefault(c, j));
                    key.put(c, min);
                } else {
                    key.put(c, key.getOrDefault(c, j) + 1);
                }
            }
        }

        //목표 문자열의 최소 키 입력 횟수 저장
        for (int i = 0; i < targets.length; i++) {
            String tmp = targets[i];
            for (int j = 0; j < tmp.length(); j++) {
                char c = tmp.charAt(j);
                if (key.containsKey(c)) {
                    answer[i] += key.get(c);
                }
                else{
                    answer[i] = -1; //목표 문자열을 작성할 수 없음
                    break;
                }
            }
        }

        return answer;
    }
}
