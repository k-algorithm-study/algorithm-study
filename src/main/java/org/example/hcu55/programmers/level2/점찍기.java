package org.example.hcu55.programmers.level2;

// 점 찍기, Programmers(Level 2)
public class 점찍기 {
    public long solution(int k, int d) {
        long answer = 0;        // 점 개수

        for (int x = 0; x <= d; x += k) {
            int maxY = (int) Math.sqrt((long) Math.pow(d, 2) - (long) Math.pow(x, 2));     // x 좌표가 주어질때 최대 y 길이
            answer += (maxY / k) + 1;       // 최대 길이를 k로 나눈 개수 + (y=0 일때 포함시키기 위해 +1)
        }
        return answer;
    }
}
