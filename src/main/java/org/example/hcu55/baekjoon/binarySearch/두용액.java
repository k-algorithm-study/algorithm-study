package org.example.hcu55.baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 두 용액, 골드 V
public class 두용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] solution = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            solution[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(solution);  // 용액 오름차순 정렬

        int low = 0;
        int high = solution.length - 1;
        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];

        while (low < high) {    // 이진탐색
            int sum = solution[low] + solution[high];
            int temp = Math.abs(sum);       // 용액 합의 절댓값 구하기
            if (temp < min) {
                min = temp;
                answer[0] = solution[low];
                answer[1] = solution[high];
            }
            if (sum > 0)
                high--;
            else
                low++;
        }
        System.out.println(answer[0] + " " + answer[1]);
    }
}
