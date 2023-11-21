package org.example.hcu55.programmers.level1;

// 문자열 나누기, Programmers(Level 1)
public class 문자열나누기 {
    public int solution(String s) {
        int answer = 0;

        char first = s.charAt(0);   // 첫 번째 문자 추출

        int firstIndex = 0;     // 첫 번째 문자와 같은 문자 개수
        int diffIndex = 0;      // 첫 번째 문자와 다른 문자 개수

        for (int i = 0; i < s.length(); i++) {
            if (firstIndex == diffIndex) {  // 개수가 같을 때
                answer++;       // 나누기
                first = s.charAt(i);    // 나눈 부분 첫번째 문자 다시 세팅
                firstIndex = 0;
                diffIndex = 0;
            }

            if (s.charAt(i) == first) {
                firstIndex++;
            } else {
                diffIndex++;
            }
        }
        return answer;
    }
}
