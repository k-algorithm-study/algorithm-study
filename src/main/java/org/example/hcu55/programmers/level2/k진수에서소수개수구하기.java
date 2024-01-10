package org.example.hcu55.programmers.level2;

import java.util.ArrayList;
import java.util.List;

// k진수에서 소수 개수 구하기, Programmers(Level 2)
public class k진수에서소수개수구하기 {
    public int solution(int n, int k) {
        int answer = 0;
        String binary = Integer.toString(n, k);         // n을 k 진법으로 변환
        List<String> nums = new ArrayList<>(List.of(binary.split("0")));

        for (String str : nums) {
            if (str.equals("")) {   // 공백이 있으면 다음 인덱스로 넘어감
                continue;
            }
            long checkNum = Long.parseLong(str);
            if (isPrime(checkNum)) {
                answer++;
            }
        }
        return answer;
    }

    public static boolean isPrime(long checkNum) {
        if (checkNum == 1) {    // 1은 소수가 아님
            return false;
        }
        for (int i = 2; i <= Math.sqrt(checkNum); i++) {
            if (checkNum % i == 0) {
                return false;
            }
        }
        return true;
    }
}