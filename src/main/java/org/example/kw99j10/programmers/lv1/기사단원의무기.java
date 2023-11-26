package org.example.kw99j10.programmers.lv1;

/**
 * 기사단원의 무기, programmers:Level 1
 */
public class 기사단원의무기 {
    public int solution(int number, int limit, int power) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {

            int count = 0;

            //for문 2개를 그냥 사용하면 시간 초과 발생
            for (int j = 1; j * j <= i; j++) {
                if (j * j == i) {
                    count += 1; //제곱수일 때 +1
                }
                else if (i % j == 0) {
                    count += 2; //그냥 악수일 때 +2
                }
            }

            //공격력 제한 수치에 따른 철의 무게 합 누적
            if (count > limit) {
                answer += power;
            }
            else{
                answer += count;
            }
        }
        return answer;
    }
}
