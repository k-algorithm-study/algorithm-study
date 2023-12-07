package org.example.hcu55.programmers.level1;

// 콜라 문제, Programmers(Level 1)
public class 콜라문제 {
    public int solution(int a, int b, int n) {
        int answer = 0;

        while (n >= a) {
            int receive = (n / a) * b;
            int remain = n % a;
            n = receive + remain;

            answer += receive;
        }
        return answer;
    }
}
