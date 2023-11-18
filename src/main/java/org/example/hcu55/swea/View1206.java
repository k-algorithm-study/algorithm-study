package org.example.hcu55.swea;

import java.util.Scanner;

public class View1206 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            int N = sc.nextInt();
            int[] tower = new int[N];

            for (int i = 0; i < N; i++) {
                tower[i] = sc.nextInt();
            }

            int total = 0;
            for (int i = 2; i < N - 2; i++) {
                int leftMax = Math.max(tower[i - 2], tower[i - 1]);
                int rightMax = Math.max(tower[i + 1], tower[i + 2]);
                int aroundMax = Math.max(leftMax, rightMax);

                if (tower[i] > aroundMax) {
                    total += tower[i] - aroundMax;
                }
            }
            System.out.println("#" + test_case + " " + total);
        }
    }
}
