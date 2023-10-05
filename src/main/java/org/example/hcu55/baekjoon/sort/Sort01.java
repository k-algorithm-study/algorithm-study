package org.example.hcu55.baekjoon.sort;

import java.util.Arrays;
import java.util.Scanner;

//수 찾기, 실버 IV
public class Sort01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];

        for(int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A);     // 정렬

        int M = sc.nextInt();
        int[] arrM = new int[M];

        for(int i = 0; i < M; i++) {
            arrM[i] = sc.nextInt();
        }

        for(int i = 0; i < M; i++) {
            System.out.println(binarySearch(A, arrM[i]));
        }

    }

    //이진 탐색 알고리즘
    public static int binarySearch(int[] arr, int num) {

        int low = 0;
        int mid = 0;
        int high = arr.length-1;

        while (low <= high) {
            mid = (low + high) / 2;
            if(arr[mid] == num)
                return 1;
            else if(arr[mid] > num)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return 0;
    }
}
