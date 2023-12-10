package org.example.kw99j10.programmers.lv1;

/**
 *  옹알이(2), programmers:Level 1
 */
public class 옹알이2 {
    public int solution(String[] babbling) {
        int answer = 0;

        String[] can = {"aya", "ye", "woo", "ma"}; //할 수 있는 발음
        String[] cant = {"ayaaya", "yeye", "woowoo", "mama"}; //할 수 없는 발음

        for (String s : babbling) {
            String tmp = s;

            for (int j = 0; j < can.length; j++) {

                if (tmp.contains(cant[j])) {
                    break; //연속해서 발음하면 x
                }

                if (tmp.contains(can[j])) {
                    tmp = tmp.replace(can[j], " ");
                }
            }
            tmp = tmp.replace(" ", "");
            if (tmp.equals("")) {
                answer += 1; //발음 가능한 문자열로 이루어진 경우 count
            }
        }

        return answer;
    }
}
