package org.example.kw99j10.programmers.lv1;
/**
 * 숫자 문자열과 영단어, programmers:Level 1
 */
public class 숫자문자열과영단어 {
    public int solution(String s) {
        String[] st = {"zero", "one", "two", "three", "four", "five"
                , "six", "seven", "eight", "nine"};

        for (int i = 0; i < st.length; i++) {
            s = s.replace(st[i], String.valueOf(i));
        }
        return Integer.parseInt(s);
    }
}
