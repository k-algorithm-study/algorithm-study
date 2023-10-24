package org.example.yumyeonghan.programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class 대충만든자판 {

  public int[] solution(String[] keymap, String[] targets) {
    int[] answer = new int[targets.length];

    //1번 키부터 차례대로 할당된 문자들이 순서대로 담긴 문자열 keymap
    //입력하려는 문자열들이 담긴 문자열 배열 targets
    //만들수 없다면 -1

    //1. map에 keymap에 등록된 키들의 눌러야 할 숫자를 최소값으로 넣어둔다
    Map<Character, Integer> move = new HashMap<>();
    for (String key : keymap) {
      for (int i = 0; i < key.length(); i++) {
        char sign = key.charAt(i);
        int step = move.getOrDefault(sign, i + 1);
        move.put(sign, Math.min(step, i + 1));
      }
    }
    //2. map에서 해당 단어에 대한 숫자를 찾아서(containsKey) 하나씩 더해준다. 만약 없다면 -1
    for (int i = 0; i < targets.length; i++) {
      for (int j = 0; j < targets[i].length(); j++) {
        char t = targets[i].charAt(j);
        if (move.containsKey(t)) {
          answer[i] += move.get(t);
        } else {
          answer[i] = -1;
          break;
        }
      }
    }
    return answer;
  }

}
