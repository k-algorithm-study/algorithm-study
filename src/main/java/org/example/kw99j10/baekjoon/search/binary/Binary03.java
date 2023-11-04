package org.example.kw99j10.baekjoon.search.binary;

import java.util.Arrays;
import java.util.Scanner;

public class Binary03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt(); // 가지고 있는 랜선의 개수
        int n = sc.nextInt(); // 필요한 랜선의 개수

        long[] arr = new long[k];
        //가지고 있는 랜선 범위 long: 2^31-1보다 작거나 같은 자연수
        for (int i = 0; i < k; i++) {
            arr[i] = sc.nextLong();
        }

        Arrays.sort(arr); //이분 탐색을 위한 정렬

        //탐색 범위 시작은 1, 끝은 배열의 마지막 요소
        long start = 1; // /by zero 오류 발생 대비
        long mid = 0;
        long end = arr[arr.length - 1];

        int count; //잘린 랜선의 총 개수

        while (start <= end) {
            mid = (start + end) / 2;

            count = 0;

            for (int i = 0; i < arr.length; i++) {
                count += arr[i] / mid;
            }

            //잘린 랜선의 개수와 필요로 하는 랜선의 개수 n을 비교
            if (count >= n) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        System.out.println(end);
    }
}
