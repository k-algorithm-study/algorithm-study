package org.example.kw99j10.baekjoon.search.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 두 용액 - Gold V
 */

public class Binary05 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); //이분 탐색을 위한 정렬

        int start = 0;
        int end = n - 1;

        int max = (int) 2e9; //나올 수 있는 최대 특성값

        //두 용액의 특성값이 0에 가장 가까운 용액을 리턴할 배열
        int[] result = new int[2];

        while (start < end) {

            int sum = arr[start] + arr[end]; //두 용액의 특성값

            //0에 가장 가까운 용액을 만들어내기 위해 합에 절댓값을 씌움
            if (max >= Math.abs(sum)) {
                result[0] = arr[start];
                result[1] = arr[end];
                max = Math.abs(sum);
            }

            //산성이면 배열 인덱스 감소
            if (sum > 0) {
                end -= 1;
            }

            //알칼리성이면 배열 인덱스 증가
            else{
                start += 1;
            }
        }
        System.out.println(result[0] + " " + result[1]);
    }
}
