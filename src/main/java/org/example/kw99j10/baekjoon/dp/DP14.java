package org.example.kw99j10.baekjoon.dp;

import java.util.Scanner;

/**
 *  퇴사 - Silver III
 */
public class DP14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] company = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            company[i][0] = sc.nextInt(); //기간
            company[i][1] = sc.nextInt(); //금액
        }

        int[] profit = new int[n + 2];
        for (int i = 1; i <= n; i++) {

            //기간 내에 일을 할 수 있는지
            if (n + 1 >= i + company[i][0]) {
                profit[i + company[i][0]] = Math.max(profit[i + company[i][0]], profit[i] + company[i][1]);
            }
            //최대 이익 갱신
            profit[i + 1] = Math.max(profit[i + 1], profit[i]);
        }
        System.out.println(profit[n + 1]);
    }
}
