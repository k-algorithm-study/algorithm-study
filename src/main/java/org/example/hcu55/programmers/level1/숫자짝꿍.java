package org.example.hcu55.programmers.level1;

import java.util.HashMap;
import java.util.Map;

// 숫자 짝꿍, Programmers(Level 1)
public class 숫자짝꿍 {
    public static String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        Map<Integer, Integer> mapX = new HashMap<>();
        Map<Integer, Integer> mapY = new HashMap<>();

        for (String data : X.split("")) {     // 숫자 각 자리수 형변환하여 map에 넣음
            int num = Integer.parseInt(data);
            mapX.put(num, mapX.getOrDefault(num, 0) + 1);
        }

        for (String data : Y.split("")) {     // Y문자열 각 자리수 형변환하여 map에 넣음
            int num = Integer.parseInt(data);
            mapY.put(num, mapY.getOrDefault(num, 0) + 1);
        }

        for (int i = 9; i >= 0; i--) {      // 9부터 X,Y에 모두 포함 된 수 찾기
            if (mapX.containsKey(i) && mapY.containsKey(i)) {
                int minCount = Math.min(mapX.get(i), mapY.get(i));
                for (int j = 0; j < minCount; j++) {
                    answer.append(i);       // 개수만큼 정답에 추가
                }
            }
        }

        if (answer.toString().equals("")) {
            return "-1";
        } else if (answer.toString().startsWith("0")) {
            return "0";
        }
        return answer.toString();
    }
}
