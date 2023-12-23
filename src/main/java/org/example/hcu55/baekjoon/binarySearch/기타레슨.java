package org.example.hcu55.baekjoon.binarySearch;

import java.util.Scanner;

// 기타 레슨, 실버 I
// https://velog.io/@chosj1526/%EB%B0%B1%EC%A4%80-2343-%EA%B8%B0%ED%83%80-%EB%A0%88%EC%8A%A8-JAVA
public class 기타레슨 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] lecture = new int[N];
        int left = 0;
        int right = 0;

        for (int i = 0; i < N; i++) {
            lecture[i] = sc.nextInt();          // 강의 시간 입력받기
            left = Math.max(left, lecture[i]);  // 강의 길이 중 최댓값이 left
            right += lecture[i];                // 총 강의 길이가 right
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;                        // 레슨 합
            int count = 0;                      // 현재 사용한 블루레이 개수

            for (int i = 0; i < N; i++) {
                if (sum + lecture[i] > mid) {   // 현재 레슨을 더했을 때 mid 값보다 크면
                    count++;                    // 블루레이 개수 증가
                    sum = 0;
                }
                sum = sum + lecture[i];         // 현재 레슨 시간 더하기
            }
            if (sum != 0) {                     // sum이 0이 아니면 마지막 블루레이가 필요
                count++;
            }
            if (count > M) {                    // 블루레이 개수가 많으면
                left = mid + 1;
            } else {                            // 블루레이 개수가 같거나 작으면
                right = mid - 1;
            }
        }
        System.out.println(left);
    }
}
