package org.example.hcu55.programmers.level2;

import java.util.HashMap;
import java.util.Map;

// 롤케이크 자르기, Programmers(Level 2)
public class 롤케이크자르기 {
    public int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> map1 = new HashMap<>();    // 철수 맵
        Map<Integer, Integer> map2 = new HashMap<>();    // 동생 맵

        for (int i : topping) {     // 동생 맵에 일단 다 넣음
            map2.put(i, map2.getOrDefault(i, 0) + 1);
        }

        for (int j : topping) {
            map1.put(j, map1.getOrDefault(j, 0) + 1);   // 하나씩 철수 맵에 넣으면서 동생 맵에서 하나씩 꺼낼꺼임

            if (map2.get(j) - 1 == 0) {     // 동생 맵에서 하나 꺼냈더니 그 토핑이 0이라면
                map2.remove(j);             // 삭제 시킴
            } else {
                map2.put(j, map2.get(j) - 1);   // 0은 안된다면 개수 줄임
            }

            if (map1.size() == map2.size())     // 철수와 동생의 맵 사이즈가 같아질 때마다 결과 증가
                answer++;
        }
        return answer;
    }
}
