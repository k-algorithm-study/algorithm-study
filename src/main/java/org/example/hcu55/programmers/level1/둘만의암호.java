package org.example.hcu55.programmers.level1;

import java.util.ArrayList;
import java.util.List;

// 둘만의 암호, Programmers(Level 1)
public class 둘만의암호 {
    public String solution(String s, String skip, int index) {
        String answer = "";
        List<Character> skipList = new ArrayList<>();

        for (int i = 0; i < skip.length(); i++) {   // 문자열 배열에 skip값 넣기
            skipList.add(skip.charAt(i));
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);       // s 문자열 하나씩 뽑기
            for (int j = 0; j < index; j++) {
                c++;
                if (c > 'z') {
                    c -= 26;    //  다시 a로 변경
                }
                if (skipList.contains(c)) {
                    j--;        // skipList에 포함되어 있는거면 다시 c 증가를 위해 j 빠꾸
                }
            }
            answer += c;
        }
        return answer;
    }
}
