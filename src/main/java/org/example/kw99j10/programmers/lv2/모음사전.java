package org.example.kw99j10.programmers.lv2;

import java.util.ArrayList;

/**
 * 모음사전, programmers:Level 2
 */
public class 모음사전 {
    static char[] dic = {'A', 'E', 'I', 'O', 'U'}; //모음사전

    public int solution(String word) {
        int answer = 0;

        var lists = new ArrayList<String>(); //모음을 사전 순으로 담을 리스트

        for (char c : dic) {
            dfs(lists, String.valueOf(c));
        }

        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).equals(word)) {
                answer = i + 1;
            }
        }
        return answer;
    }
    static void dfs(ArrayList<String> lists, String str) {

        if (str.length() > dic.length) {
            return;
        }

        if (!lists.contains(str)) {
            lists.add(str);
        }

        for (char c : dic) {
            dfs(lists, str + c);
        }
    }
}
