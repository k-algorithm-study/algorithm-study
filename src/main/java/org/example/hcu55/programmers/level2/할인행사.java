package org.example.hcu55.programmers.level2;

import java.util.HashMap;
import java.util.Map;

// 할인 행사, Programmers(Level 2)
public class 할인행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < want.length; i++) {     // 정현이가 원하는 물품 이름과 개수 map에 넣음
            map.put(want[i], number[i]);
        }

        for (int i = 0; i <= discount.length - 10; i++) {       // 할인하는 제품을 10일씩 순서대로 discountMap이랑 비교
            Map<String, Integer> discountMap = new HashMap<>();

            for (int j = 0; j < 10; j++) {
                discountMap.put(discount[i + j], discountMap.getOrDefault(discount[i + j], 0) + 1);
            }

            boolean isEquals = true;

            for (String s : map.keySet()) {     // map과 countMap 비교시 다르다면 false
                if (!map.get(s).equals(discountMap.get(s))) {
                    isEquals = false;
                    break;
                }
            }
            if (isEquals) {
                answer++;
            }
        }
        return answer;
    }
}
