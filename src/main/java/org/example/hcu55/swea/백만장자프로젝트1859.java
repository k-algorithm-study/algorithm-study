package org.example.hcu55.swea;

import java.util.Scanner;

public class 백만장자프로젝트1859 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            long money = 0L;
            int n = sc.nextInt();
            int[] price = new int[n];
            for (int i = 0; i < n; i++) {
                price[i] = sc.nextInt();
            }

            int max = price[n - 1];
            for (int k = n - 2; k >= 0; k--) {
                if (price[k] > max) {
                    max = price[k];
                } else {
                    money += max - price[k];
                }
            }
            System.out.println("#" + test_case + " " + money);
        }
    }
}
