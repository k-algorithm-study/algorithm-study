package org.example.hcu55.swea;

import java.util.Arrays;
import java.util.Scanner;

public class Flatten1208 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            int dump = sc.nextInt();
            int max = 0, min = 0;
            int[] boxHeight = new int[100];
            for (int i = 0; i < 100; i++) {
                boxHeight[i] = sc.nextInt();
            }
            for (int j = 0; j < dump; j++) {
                Arrays.sort(boxHeight);
                if (boxHeight[99] - boxHeight[0] <= 1) {
                    break;
                }
                boxHeight[99]--;
                boxHeight[0]++;
            }
            Arrays.sort(boxHeight);
            int diff = boxHeight[99] - boxHeight[0];

            System.out.println("#" + test_case + " " + diff);
        }
    }
}
