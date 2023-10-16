package org.example.hcu55.programmers.level1;

import java.util.HashMap;
import java.util.Map;

// 추억 점수, Programmers(Level 1)
public class 추억점수 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        // 결과를 담을 배열
        int[] answer = new int[photo.length];

        // 사진의 추억 점수를 담을 map 선언
        Map<String, Integer> map = new HashMap<>();

        // map에 이름에 따른 그리움 점 입력
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            // 이차원 배열 1차원 배열로 꺼냄
            String[] person = photo[i];
            int score = 0;

            for (int j = 0; j < person.length; j++) {
                String personName = person[j];
                // personName이 map에 있는 경우 해당 사람의 추억점수 더하기
                if (map.containsKey(personName)) {
                    score += map.get(personName);
                }
            }
            answer[i] = score;
        }
        return answer;
    }
}
