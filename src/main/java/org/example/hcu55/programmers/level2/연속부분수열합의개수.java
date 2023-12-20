package org.example.hcu55.programmers.level2;

import java.util.HashMap;
import java.util.Map;

// 연속 부분 수열 합의 개수, Programmers(Level 2)
public class 연속부분수열합의개수 {
    public int solution(int[] elements) {
        int[] sumArr = new int[elements.length * 2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < elements.length; i++) {     // 원래 배열 반복하여 두배로 만들기
            sumArr[i] = sumArr[i + elements.length] = elements[i];
        }

        for (int i = 0; i < elements.length; i++) {
            int sum = 0;
            for (int j = i; j < i + elements.length; j++) {     // 현재 지점부터 배열의 길이 만큼 더해줌
                sum += sumArr[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);     // 합을 맵에 넣음
            }
        }
        return map.size();
    }
}
