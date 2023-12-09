package org.example.hcu55.programmers.level1;

// 크기가 작은 부분 문자열, Programmers(Level 1)
public class 크기가작은부분문자열 {
    public int solution(String t, String p) {
        int answer = 0;

        for (int i = 0; i < t.length() - p.length() + 1; i++) {
            String temp = t.substring(i, i + p.length());

            if (Long.parseLong(temp) <= Long.parseLong(p)) {
                answer++;
            }
        }
        return answer;
    }
}
