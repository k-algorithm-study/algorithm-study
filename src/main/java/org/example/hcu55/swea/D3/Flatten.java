package org.example.hcu55.swea.D3;

import java.util.*;

public class Flatten {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int testCase = 1; testCase <= 10; testCase++) {
            int dump = sc.nextInt();            // 덤프 횟수 받기
            int[] boxes = new int[100];         // 상자 배열 생성

            for (int i = 0; i < boxes.length; i++) {        // 상자 높이 입력 받기
                boxes[i] = sc.nextInt();
            }

            int max, min;               // 최대, 최소 값 변수
            int maxIndex, minIndex;     // 최대, 최소 인덱스 변수

            for (int i = 0; i < dump; i++) {
                max = Integer.MIN_VALUE;            // 덤프 하기전 초기화
                min = Integer.MAX_VALUE;
                maxIndex = 0;
                minIndex = 0;

                for (int j = 0; j < boxes.length; j++) {
                    if (boxes[j] > max) {
                        max = boxes[j];
                        maxIndex = j;
                    }

                    if (boxes[j] < min) {
                        min = boxes[j];
                        minIndex = j;
                    }
                }
                boxes[maxIndex] -= 1;       // 최대 상자 감소
                boxes[minIndex] += 1;       // 최소 상자 감소
            }

            // 출력
            int max_result = Integer.MIN_VALUE;     // 최종 최댓값 변수
            int min_result = Integer.MAX_VALUE;     // 최종 최솟값 변수

            for (int k = 0; k < boxes.length; k++) {
                if (boxes[k] > max_result) {
                    max_result = boxes[k];
                }

                if (boxes[k] < min_result) {
                    min_result = boxes[k];
                }
            }
            System.out.println("#" + testCase + " " + (max_result - min_result));
        }
    }
}
