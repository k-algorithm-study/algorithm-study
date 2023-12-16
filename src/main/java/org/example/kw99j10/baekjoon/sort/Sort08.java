package org.example.kw99j10.baekjoon.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 두 수의 합 - Silver III
 */
public class Sort08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int x = sc.nextInt(); //수열에 포함되는 수

        //a+b=x를 만족함
        int a = 0;
        int b = n - 1;
        int count = 0;

        while (a < b) {
            if (arr[a] + arr[b] == x) {
                a += 1;
                b -= 1;
                count += 1;
            }
            else if (arr[a] + arr[b] > x) {
                b -= 1;
            }
            else{
                a += 1;
            }
        }
        System.out.println(count);
    }
}
