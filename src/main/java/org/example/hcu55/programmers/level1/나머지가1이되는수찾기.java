package org.example.hcu55.programmers.level1;

// 나머지가 1이 되는 수 찾기, Programmers(Level 1)
public class 나머지가1이되는수찾기 {
    public int solution(int n) {
        int answer = 0;

        for (int i = 2; i < n; i++) {
            if ((n - 1) % i == 0) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}
