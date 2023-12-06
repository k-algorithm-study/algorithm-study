package org.example.hcu55.programmers.level2;

import java.util.ArrayList;
import java.util.List;

// 우박수열 정적분, Programmers(Level 2)
public class 우박수열정적분 {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];

        int n = 0;  // k가 1까지 될 횟수
        List<Integer> yList = new ArrayList<>();

        while (k >= 1) {
            yList.add(k);       // n+1의 크기가 될것임

            if (k == 1) break;
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k = k * 3 + 1;
            }
            n++;
        }

        double[] prefixSum = new double[yList.size()];     // 누적 합 배열
        prefixSum[0] = 0;
        double sum = 0;

        for (int i = 1; i <= n; i++) {      // 누적 합 배열 채우기
            double area = (double) (yList.get(i - 1) + yList.get(i)) / 2;    // 면적구하기
            sum += area;
            prefixSum[i] = sum;
        }

        for (int i = 0; i < ranges.length; i++) {       // 누적합 배열에서 꺼내 정적분 구하기
            int left = ranges[i][0];
            int right = ranges[i][1];

            if (left > n + right) {     // 우측 값이 더 크면 구할 수 없음
                answer[i] = -1;
            } else if (left == n + right) {     // 값이 같으면 정적분 값은 0이다.
                answer[i] = 0;
            } else {
                answer[i] = prefixSum[n + right] - prefixSum[left];
            }
        }
        return answer;
    }
}
