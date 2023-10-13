package org.example.kw99j10.baekjoon.search.binary;

import java.util.Arrays;
import java.util.Scanner;

public class Binary02 {

    static int[] arr;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //나무의 수
        int m = sc.nextInt(); //필요한 나무의 길이

        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr); //이분 탐색을 위한 정렬
        //ex)10, 15, 17, 20

        //탐색 범위 시작은 0, 끝은 배열의 마지막 요소
        int start = 0;
        int mid = 0;
        int end = arr[arr.length - 1];

        long sum;
        while (start <= end) {

            mid = (start + end) / 2;

            sum = 0;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > mid) {
                    sum += (arr[i] - mid); //mid 값 보다 높으면 나무를 자름
                }
            }

            if (sum >= m) {
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        System.out.println(end);
    }
}
