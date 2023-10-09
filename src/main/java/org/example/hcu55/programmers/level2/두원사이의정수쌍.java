package org.example.hcu55.programmers.level2;

// 두 원 사이의 정수 쌍, Programmers(Level 2)
public class 두원사이의정수쌍 {
    public long solution(int r1, int r2) {
        long answer = 0;
        long d1 = (long) Math.pow(r1, 2);
        long d2 = (long) Math.pow(r2, 2);
        long side = 0;

        for (long i = 0; i <= r2; i++) {
            long y2 = (long) Math.sqrt(d2 - i * i);
            long y1 = (long) Math.sqrt(d1 - i * i);

            if (Math.sqrt(d1 - i * i) % 1 == 0) {
                side++;
            }
            answer += (y2 - y1) * 4;
        }
        answer += side * 4;
        answer -= 4;    // 겹치는 쌍 제거
        return answer;
    }
}
