package org.example.hcu55.swea;

import java.util.Scanner;

public class 평균값구하기2071 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int[] nubmers = new int[10];
            double sum = 0;
            for (int i = 0; i < 10; i++) {
                nubmers[i] = sc.nextInt();
                sum += nubmers[i];
            }
            System.out.println("#" + test_case + " " + Math.round(sum/10));
        }
    }
}
