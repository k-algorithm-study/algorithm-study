package org.example.kw99j10.programmers.lv1;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 개인정보 수집 유효기간, programmers:Level 1
 */
public class 개인정보수집유효기간 {
    public int[] solution(String today, String[] terms, String[] privacies) {

        String[] current = today.split("\\.");

        int current_year = Integer.parseInt(current[0]); //현재 년도
        int current_month = Integer.parseInt(current[1]); //현재 월
        int current_day = Integer.parseInt(current[2]); //현재 일

        //현재 년도 + 월 + 일을 숫자의 총합으로 표현
        int current_total = current_year * 12 * 28 + current_month * 28 + current_day;

        var h = new HashMap<String, Integer>();
        for (String term : terms) {
            String[] t = term.split(" ");
            h.put(t[0], Integer.parseInt(t[1])); //약관 종류, 유효 기간을 저장
        }

        var a = new ArrayList<Integer>(); //만료된 개인정보를 담을 리스트

        for (int i = 0; i < privacies.length; i++) {
            String[] tmp = privacies[i].split(" ");

            String[] year = tmp[0].split("\\."); //날짜
            String category = tmp[1]; //약관 종류

            //개인정보 수집 시작 기간
            int pv_year = Integer.parseInt(year[0]);
            int pv_month = Integer.parseInt(year[1]);
            int pv_day = Integer.parseInt(year[2]);

            int pv_total = pv_year * 12 * 28 + pv_month * 28 + pv_day;

            pv_total += h.get(category) * 28;

            System.out.println(current_total + " " + pv_total);

            //당일 날짜까지라면 만료되었으므로 리스트에 추가
            if (current_total >= pv_total) {
                a.add(i + 1);
            }
        }
        int[] answer = new int[a.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = a.get(i);
        }
        return answer;
    }
}
