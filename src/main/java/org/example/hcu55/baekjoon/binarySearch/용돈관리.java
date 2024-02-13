package org.example.hcu55.baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 용돈 관리, 실버 II
public class 용돈관리 {
    public static int N, M;
    public static int[] arr;
    public static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        binarySearch();
    }

    public static void binarySearch() {
        int left = max;
        int right = 1000000000;               // 최대 10000 * 100000 = 1000000000

        while (left <= right) {
            int mid = (left + right) / 2;

            int cnt = 1;                     //처음에는 돈 빌리고 시작함
            int nowMoney = mid;

            for (int i = 0; i < N; i++) {
                if (nowMoney - arr[i] < 0) { //돈이 부족하면, 돈을 다시 인출
                    nowMoney = mid;
                    cnt += 1;
                }
                nowMoney -= arr[i];          //돈을 사용
            }

            if (cnt > M) {  //사용한 횟수가 M보다 크다면, 돈의 크기를 크게해줘야 cnt가 줄어듬
                left = mid + 1;
            } else {        //사용한 횟수가 M보다 작거나 같다면, 돈의 크기를 작게해줘야 cnt가 증가함
                right = mid - 1;
            }
        }
        System.out.println(left);
    }
}