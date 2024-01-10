package org.example.hcu55.programmers.level2;

import java.util.ArrayList;
import java.util.List;

// 모음사전, Programmers(Level 2)
public class 모음사전 {
    static List<String> list;
    static String[] words = {"A", "E", "I", "O", "U"};

    public int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();

        dfs("", 0);         // dfs

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }

    static void dfs(String str, int len) {
        list.add(str);
        if (len == 5) {
            return;
        }

        for (int i = 0; i < 5; i++) {
            dfs(str + words[i], len + 1);
        }
    }
}
