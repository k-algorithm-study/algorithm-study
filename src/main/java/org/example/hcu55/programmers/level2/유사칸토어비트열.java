package org.example.hcu55.programmers.level2;

// 유사 칸토어 비트열, Programmers(Level 2)
public class 유사칸토어비트열 {
    public int solution(int n, long l, long r) {
        int answer = 0;

        for (long i = l; i <= r; i++) {
            int flag;
            if (i % 5 == 3) {
                continue;
            }
            long temp = i;
            while (true) {
                if (temp % 5 == 0) {
                    temp = temp / 5;
                } else {
                    temp = (temp / 5) + 1;
                }

                if (temp % 5 == 3) {
                    flag = 0;
                    break;
                } else if (temp <= 5) {
                    flag = 1;
                    break;
                }
            }

            if (flag == 1) answer++;
        }
        return answer;
    }
}