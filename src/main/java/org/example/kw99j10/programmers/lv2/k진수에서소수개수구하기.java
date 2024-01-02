package org.example.kw99j10.programmers.lv2;

import java.util.StringTokenizer;

/**
 * k진수에서 소수 개수 구하기, programmers:Level 2
 */
public class k진수에서소수개수구하기 {
    public int solution(int n, int k) {
        int answer = 0;

        String tmp = Integer.toString(n, k); //n을 k진수로 변환

        //0으로 분리
        StringTokenizer st = new StringTokenizer(tmp, "0");
        while (st.hasMoreTokens()) {

            boolean prime = true; //소수를 판별할 변수
            long t = Long.parseLong(st.nextToken()); //int형 오버 플로우 발생

            //소수 판별
            for (int i = 2; i <= Math.sqrt(t); i++) {
                if (t % i == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime && t != 1) {
                answer += 1; //해당 수가 소수이면서 1이 아닐 때
            }
        }
        return answer;
    }
}
