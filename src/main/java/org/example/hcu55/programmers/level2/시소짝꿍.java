package org.example.hcu55.programmers.level2;

import java.util.Arrays;

// 시소 짝꿍, Programmers(Level 2)
public class 시소짝꿍 {
    public long solution(int[] weights) {
        long answer = 0;
        int count = 0;
        Arrays.sort(weights);

        for (int i = 0; i < weights.length - 1; i++) {
            if (i > 0) {
                if (weights[i] == weights[i - 1]) {
                    count--;        // 같은 무게인 경우 중복을 피하기 위해 하나 뺴줌
                    answer += count;
                    continue;
                }
            }
            count = 0;
            for (int j = i + 1; j < weights.length; j++) {
                if (weights[i] == weights[j] ||
                        weights[i] * 2 == weights[j] ||
                        weights[i] * 3 == weights[j] * 2 ||
                        weights[i] * 4 == weights[j] * 3) {
                    count++;
                }
            }
            answer += count;
        }
        return answer;
    }
}
