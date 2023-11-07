package org.example.kw99j10.programmers.lv2;

import java.util.Arrays;

/**
 * 숫자 변환하기, programmers:Level 2
 */
public class 숫자변환하기 {
    static final int INF = 1000001; //배열을 채울 상수

    public int solution(int x, int y, int n) {

        int[] dp = new int[y + 1]; //y+1 크기의 배열 설정
        Arrays.fill(dp, INF);

        //x -> y를 만들어야 하므로 x+1 부터 실행, x일 때는 0
        dp[x] = 0;

        for (int i = x + 1; i <= y; i++) {

            int a = INF; // x에 n을 더함
            int b = INF; //x에 2를 곱함
            int c = INF; //x에 3을 곱함

            if (i % 3 == 0) {
                c = dp[i / 3] + 1;
            }
            if (i % 2 == 0) {
                b = dp[i / 2] + 1;
            }
            if (i - n >= x) {
                a = dp[i - n] + 1;
            }
            int min = Math.min(a, Math.min(b, c));
            dp[i] = Math.min(INF, min);
        }
        return dp[y] == INF ? -1 : dp[y];
    }
}
