package org.example.kw99j10.baekjoon.search.binary;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 좋다 - Gold IV
 */
public class Binary08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr); //이분 탐색을 위한 배열 정렬

        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            int start = 0;
            int end = n - 1;

            long sum = arr[i]; //"좋다"를 나타낼 값(다른 수 두개의 합)

            //start != end: 다른 수 두 개의 합으로 나타내야 함
            while (start < end) {
                if (arr[start] + arr[end] > sum) {
                    end -= 1;
                }
                else if (arr[start] + arr[end] < sum) {
                    start += 1;
                }
                else {
                    if (start != i && end != i){
                        count += 1; //조건을 만족하는 쌍
                        break;
                    }
                    else if(start == i){
                        start += 1; //중복 방지: 같은 값이 두 번 선택될 수 있음
                    }
                    else {
                        end -= 1; //중복 방지
                    }
                }
            }
        }
        System.out.println(count);
    }
}
