package org.example.kw99j10.programmers.lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class 귤고르기 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        //map에 수확한 귤의 크기에 따른 개수 저장
        for (int j : tangerine) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }

        //서로 다른 종류의 수 최소화하기 위해서는 귤의 크기의 따른 개수가 많은 순으로 정렬 필요
        var a = new ArrayList<>(map.values());
        a.sort(Collections.reverseOrder()); //개수가 많은 순으로 정렬

        for (Integer integer : a) {

            if (k <= 0) {
                break;
            }
            k -= integer;
            answer += 1;
        }
        return answer;
    }
}
