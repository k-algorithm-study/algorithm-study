package org.example.hcu55.baekjoon.sort;

import java.io.*;
import java.util.*;

// 전화번호 목록, 골드 IV
public class 전화번호목록 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];

            for (int j = 0; j < n; j++) {
                arr[j] = br.readLine();
            }

            Arrays.sort(arr);       // 오름차순

            if (search(arr)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean search(String[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1].startsWith(arr[i])) {
                return false;
            }
        }
        return true;
    }
}
