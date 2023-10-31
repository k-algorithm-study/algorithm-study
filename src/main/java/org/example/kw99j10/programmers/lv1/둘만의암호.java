package org.example.kw99j10.programmers.lv1;

import java.util.ArrayList;

/**
 *  둘만의 암호, programmers:Level 1
 */
public class 둘만의암호 {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        var password = new ArrayList<Character>();
        for (int i = 0; i < skip.length(); i++) {
            password.add(skip.charAt(i)); //skip에 있는 알파벳을 리스트에 저장
        }

        for (int i = 0; i < s.length(); i++) {
            int tmp = s.charAt(i);

            int num = 0; //num 변수가 index에 도달하면 반복문 종료
            while (num != index) {
                tmp += 1;
                if (tmp > 122) {
                    tmp -= 26; //z를 넘어갈 경우 다시 a로 돌아옴
                }
                if (password.contains((char) tmp)) {
                    continue; //skip에 포함된 알파벳일 경우 넘어감
                }
                num += 1;
            }
            answer.append((char) tmp);
        }
        return answer.toString();
    }
}
