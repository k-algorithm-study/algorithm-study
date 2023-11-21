package org.example.kw99j10.programmers.lv1;

import java.util.ArrayList;

/**
 * 문자열 나누기, programmers:Level 1
 */
public class 문자열나누기 {
    public int solution(String s) {

        var a = new ArrayList<String>();

        int count_first = 1; //첫 글자 나온 횟수
        int count_other = 0; //다른 글자 나온 횟수

        char first = s.charAt(0); //첫 글자

        String tmp = String.valueOf(s.charAt(0)); //나눌 문자

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);

            //문자열을 초기화한 상태에서는 첫 글자만 초기화함
            if (tmp.equals("")) {
                first = c;
            }
            else {
                if (c == first) {
                    count_first += 1;
                }
                else{
                    count_other += 1;
                }
            }

            tmp += c; //문자열 누적

            //처음 글자 횟수와 다른 글자 횟수가 같다면
            //리스트에 여태까지 누적한 문자열을 더한 후 문자열 초기화 & count 초기화
            if (count_first == count_other) {
                a.add(tmp);
                tmp = "";
                count_first = 1;
                count_other = 0;
            }
        }

        //문자열 끝까지 진행했을 때 리스트에 들어가지 않은 경우
        if (!tmp.equals("")) {
            a.add(tmp);
        }
        return a.size();
    }
}
