package org.example.hcu55.programmers.level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 개인정보 수집 유효기간, Programmers(Level 1)
public class 개인정보수집유효기간 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> answerList = new ArrayList<>();

        int todayDate = getDateToDays(today);     // 날짜 일수로 변경

        for (String s : terms) {
            String[] term = s.split(" ");
            map.put(term[0], Integer.parseInt(term[1]));    // 약관 종류, 유효기간 넣기
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");     // 날짜와 약관 종류로 구분

            if (getDateToDays(privacy[0]) + (map.get(privacy[1]) * 28) <= todayDate) {    // 오늘 날짜보다 작다면 파기해야함
                answerList.add(i + 1);
            }
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    public static int getDateToDays(String str) {
        String[] date = str.split("\\.");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);

        return (year * 12 * 28) + (month * 28) + day;
    }
}
