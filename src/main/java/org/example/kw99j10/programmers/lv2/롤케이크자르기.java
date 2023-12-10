package org.example.kw99j10.programmers.lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 롤케이크 자르기, programmers:Level 2
 */
public class 롤케이크자르기 {
    public int solution(int[] topping) {
        int answer = 0;

        var a = new HashSet<Integer>(); //철수의 토핑

        var h = new HashMap<Integer, Integer>(); //동생의 토핑

        //토핑의 종류별 개수를 담을 map
        for (int j : topping) {
            h.put(j, h.getOrDefault(j, 0) + 1);
        }

        for (int j : topping) {
            a.add(j);
            h.put(j, h.getOrDefault(j, 0) - 1);

            if (h.get(j) == 0) {
                h.remove(j); //토핑이 없으면 map에서 제거
            }

            if (a.size() == h.size()) {
                answer += 1; //두명의 토핑의 개수가 같으면 +1
            }
        }
        return answer;
    }
}
