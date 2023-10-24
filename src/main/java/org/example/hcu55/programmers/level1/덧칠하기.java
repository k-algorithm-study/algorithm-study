package org.example.hcu55.programmers.level1;

// 덧칠하기, Programmers(Level 1)
public class 덧칠하기 {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int paintLen = 0;

        for (int i = 0; i < section.length; i++) {
            if (section[i] < paintLen) {    // 페인트 칠한 곳보다 작을 땐 패스
                continue;
            }

            answer += 1;                 // 처음 max=0이기에 한번은 칠함
            paintLen = section[i] + m;   // 섹션 시작에서 롤러 길이 만큼이 페인트 칠한 곳
        }

        return answer;
    }
}
