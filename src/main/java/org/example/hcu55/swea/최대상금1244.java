package org.example.hcu55.swea;

import java.util.Scanner;

public class 최대상금1244 {
    static int[] numArr;
    static int max, swap;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            String num = sc.next();
            swap = sc.nextInt();
            numArr = new int[num.length()];
            for (int i = 0; i < num.length(); i++)
                numArr[i] = num.charAt(i) - '0';
            max = 0;
            dfs(0, 0);
            System.out.println("#" + test_case + " " + max);
        }
    }

    static void dfs(int depth, int cnt) {
        if (cnt == swap) {
            int sum = 0;
            for (int i = 0; i < numArr.length; i++)
                sum = sum * 10 + numArr[i];
            if (max < sum)
                max = sum;
            return;
        }

        for (int i = depth; i < numArr.length; i++) {
            for (int j = i + 1; j < numArr.length; j++) {
                if (numArr[i] <= numArr[j]) {
                    swap(numArr, i, j);
                    dfs(i, cnt + 1);
                    swap(numArr, i, j);
                }
            }
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}