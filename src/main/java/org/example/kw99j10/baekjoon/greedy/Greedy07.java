package org.example.kw99j10.baekjoon.greedy;

import java.util.Scanner;

/**
 * 주유소 - Silver III
 */
public class Greedy07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long cost = 0L; //최소 비용

        int[] city = new int[n]; //도로의 길이
        int[] liter = new int[n]; //리터당 가격

        for (int i = 0; i < n - 1; i++) {
            city[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            liter[i] = sc.nextInt();
        }

        long min = liter[0]; //한번은 그냥 기름을 넣고 이동

        for (int i = 0; i < n - 1; i++) {

            //최소 리터당 가격 갱신
            if (min > liter[i]) {
                cost += (long) liter[i] * city[i];
                min = liter[i];
            }

            else{
                cost += min * city[i]; //최소 리터가 갱신되기 전까지 최소 비용을 구함
            }
        }
        System.out.println(cost);
    }
}
