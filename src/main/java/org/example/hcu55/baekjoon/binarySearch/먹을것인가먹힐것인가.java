package org.example.hcu55.baekjoon.binarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 먹을 것인가 먹힐 것인가, 실버 III
public class 먹을것인가먹힐것인가 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int[] arrA = new int[A];
            int[] arrB = new int[B];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < A; j++) {
                arrA[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < B; j++) {
                arrB[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arrB);
            int result = 0;

            for (int j = 0; j < A; j++) {
                int low = 0;
                int high = B - 1;

                while (low <= high) {
                    int mid = (low + high) / 2;

                    if (arrA[j] > arrB[mid]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                result += low;
            }
            System.out.println(result);
        }
    }
}
