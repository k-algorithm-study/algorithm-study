package org.example.hcu55.swea.D3;

import java.util.*;

public class 최대상금 {
    static String[] numArr;
    static int max, exchange;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            numArr = sc.next().split("");         // 숫자 한자리씩 배열에 넣기(최대 6자리)
            exchange = sc.nextInt();                    // 교환 횟수
            max = 0;

            // 시간초과 최적화
            if (numArr.length < exchange) {    // swap 횟수가 자릿수보다 클 때
                exchange = numArr.length;      // 자릿수만큼만 옮겨도 전부 옮길 수 있음
            }

            dfs(0, 0);

            System.out.println("#" + testCase + " " + max);
        }
    }

    static void dfs(int start, int cnt) {
        if (cnt == exchange) {
            String result = "";

            for (String s : numArr) {
                result += s;
            }
            max = Math.max(max, Integer.parseInt(result));
            return;
        }

        for (int i = start; i < numArr.length; i++) {
            for (int j = i + 1; j < numArr.length; j++) {
                // swap
                String temp = numArr[i];
                numArr[i] = numArr[j];
                numArr[j] = temp;

                dfs(i, cnt + 1);    // 깊이 +1

                // 다시 swap 해서 되돌림
                temp = numArr[i];
                numArr[i] = numArr[j];
                numArr[j] = temp;
            }
        }
    }
}
