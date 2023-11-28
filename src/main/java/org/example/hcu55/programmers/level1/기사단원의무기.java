package org.example.hcu55.programmers.level1;

// 기사단원의 무기, Programmers(Level 1)
public class 기사단원의무기 {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] divisor = new int[number];
        int count = 0;
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j * j <= i; j++) {      // 약수 개수 구하기 최적화 방법으로 해야 시간 초과가 안남 일반적으로 했을 땐 시간 초과
                if (j * j == i) {
                    count++;
                } else if (i % j == 0) {
                    count += 2;
                }
            }
            if (count > limit) {    // limit 보다 약수의 개수가 많다면
                divisor[i - 1] = power;     // 그 무기 공격력은 power 로 변경
            } else {
                divisor[i - 1] = count;
            }
            count = 0;
        }

        for (int num : divisor) {   // 총 약수 개수 더하기
            answer += num;
        }
        return answer;
    }
}
