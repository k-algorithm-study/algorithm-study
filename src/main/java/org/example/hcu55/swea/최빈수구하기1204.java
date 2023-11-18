package org.example.hcu55.swea;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 최빈수구하기1204 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[] numbers = new int[1000];
            Map<Integer, Integer> numberMap = new HashMap<>();
            for (int i = 0; i < 1000; i++) {
                numbers[i] = sc.nextInt();
                numberMap.put(numbers[i], numberMap.getOrDefault(numbers[i], 0) + 1);
            }
            int maxKey = -1;
            int maxValue = -1;
            for (Map.Entry<Integer, Integer> entry : numberMap.entrySet()) {
                if (entry.getValue() > maxValue || (entry.getValue() == maxValue && entry.getKey() > maxKey)) {
                    maxKey = entry.getKey();
                    maxValue = entry.getValue();
                }
            }
            System.out.println("#" + N + " " + maxKey);
        }
    }
}
