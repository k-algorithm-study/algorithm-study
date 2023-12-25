package org.example.kw99j10.programmers.lv1;

/**
 * 성격 유형 검사하기, programmers:Level 1
 */
public class 성격유형검사하기 {
    public String solution(String[] survey, int[] choices) {
        String answer = "";

        //1번~4번 지표
        int r = 0;
        int t = 0; //RT

        int c = 0;
        int f = 0; //CF

        int j = 0;
        int m = 0; //JM

        int a = 0;
        int n = 0; //AN

        for (int i = 0; i < survey.length; i++) {

            String tmp = survey[i];
            int score = choices[i];

            if (tmp.charAt(0) == 'N') {
                if (score > 4) {
                    a += score - 4;
                }
                else{
                    n += 4 - score;
                }
            }

            if (tmp.charAt(0) == 'A') {
                if (score > 4) {
                    n += score - 4;
                }
                else{
                    a += 4 - score;
                }
            }

            if (tmp.charAt(0) == 'F') {
                if (score > 4) {
                    c += score - 4;
                }
                else{
                    f += 4 - score;
                }
            }

            if (tmp.charAt(0) == 'C') {
                if (score > 4) {
                    f += score - 4;
                }
                else{
                    c += 4 - score;
                }
            }

            if (tmp.charAt(0) == 'M') {
                if (score > 4) {
                    j += score - 4;
                }
                else{
                    m += 4 - score;
                }
            }

            if (tmp.charAt(0) == 'J') {
                if (score > 4) {
                    m += score - 4;
                }
                else{
                    j += 4 - score;
                }
            }

            if (tmp.charAt(0) == 'R') {
                if (score > 4) {
                    t += score - 4;
                }
                else{
                    r += 4 - score;
                }
            }

            if (tmp.charAt(0) == 'T') {
                if (score > 4) {
                    r += score - 4;
                }
                else{
                    t += 4 - score;
                }
            }
        }

        answer += r >= t ? "R" : "T";  //같다면 사전 순
        answer += c >= f ? "C" : "F";
        answer += j >= m ? "J" : "M";
        answer += a >= n ? "A" : "N";
        return answer;
    }
}
