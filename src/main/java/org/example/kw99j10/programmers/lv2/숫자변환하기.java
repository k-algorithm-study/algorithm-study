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

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i - n >= x) {
                dp[i] = Math.min(dp[i], dp[i - n] + 1);
            }
        }
        return dp[y] == INF ? -1 : dp[y];
    }
}
