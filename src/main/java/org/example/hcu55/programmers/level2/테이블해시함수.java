package org.example.hcu55.programmers.level2;

import java.util.Arrays;

// 테이블 해시 함수, Programmers(Level 2)
public class 테이블해시함수 {
    public static int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        Arrays.sort(data, ((o1, o2) -> {        // 먼저 정렬
            if (o1[col - 1] == o2[col - 1]) {   // col 번째 값이 동일하면
                return o2[0] - o1[0];           // 첫 번재 컬럼의 값을 기준으로 내림차순
            } else {
                return o1[col - 1] - o2[col - 1];   // col 번째 컬럼의 값을 기준으로 오름차순
            }
        }));

        for (int i = row_begin; i <= row_end; i++) {
            int sum = 0;
            for (int j = 0; j < data[i - 1].length; j++) {
                sum += data[i - 1][j] % i;          // i 번째 행의 튜플에 대해 각 컬럼의 값을 i로 나눈 나머지의 합
            }
            answer ^= sum;      // 각 합이 XOR 연산
        }
        return answer;
    }
}
