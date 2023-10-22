package org.example.kw99j10.programmers.lv1;

/**
 * 덧칠하기, programmers:Level 1
 */
public class 덧칠하기 {
    public int solution(int n, int m, int[] section) {
        int answer = 0;


        int start = section[0];
        answer += 1; //페인트칠을 1회 이상은 실행함

        for (int i = 1; i < section.length; i++) {

            //다시 칠해야 하는 구역과 현재 페인트칠의 범위를 비교
            if (section[i] > start + m - 1) {
                start = section[i];
                answer += 1;
            }
        }
        return answer;
    }
}
