package org.example.hcu55.programmers.level1;

import java.util.HashMap;
import java.util.Map;

// 대충 만든 자판, Programmers(Level 1)
public class 대충만든자판 {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> map = new HashMap<>();      // 해쉬 맵 사용

        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                if (map.containsKey(keymap[i].charAt(j))) {
                    int keyCount = map.get(keymap[i].charAt(j));    // 현재 맵에 문자의 횟수 값
                    if (keyCount > (j + 1)) {
                        map.put(keymap[i].charAt(j), j + 1);
                    }
                } else {    // 맵에 존재하지 않는 키는 새로 넣어주기
                    map.put(keymap[i].charAt(j), j + 1);
                }
            }
        }

        for (int i = 0; i < targets.length; i++) {
            String targetStr = targets[i];  // target 문자 빼오기

            for (int j = 0; j < targetStr.length(); j++) {
                char key = targetStr.charAt(j);     // 문자의 각각의 값

                if (map.containsKey(key)) {         // 맵에 있으면 값 꺼내서 더해줌
                    answer[i] += map.get(key);
                } else {        // 맵에도 없으면 -1 반환 후 종료
                    answer[i] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}
